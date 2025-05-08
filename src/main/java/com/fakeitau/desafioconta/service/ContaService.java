package com.fakeitau.desafioconta.service;

import com.fakeitau.desafioconta.application.controller.web.dtos.ConsultaRespostaController;
import com.fakeitau.desafioconta.application.controller.web.dtos.ConsultaRespostaMock;
import com.fakeitau.desafioconta.infrastructure.client.MockApiClient;
import com.fakeitau.desafioconta.infrastructure.client.repository.ConsultaRepository;
import com.fakeitau.desafioconta.model.entity.Consultas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContaService {

    private static final Logger log = LoggerFactory.getLogger(ContaService.class);
    private final MockApiClient clientMock;

    private final ConsultaRepository repository;

    public ContaService(MockApiClient clientMock, ConsultaRepository repository){
        this.clientMock = clientMock;
        this.repository = repository;
    }


    @Transactional
    public ConsultaRespostaController consultarConta(String idConta){
        try{
            log.info("Consultando conta no serviço externo com ID: {}", idConta);
            ConsultaRespostaMock resposta = clientMock.consultaContaExterno(idConta);

            var novaConsulta = new Consultas();

            novaConsulta.setAgencia(resposta.agencia());
            novaConsulta.setConta(resposta.conta());
            novaConsulta.setDac(resposta.dac());
            novaConsulta.setIdConta(idConta);
            novaConsulta.setSaldo(resposta.saldo());
            novaConsulta.setIdCliente(resposta.idCliente());

            repository.save(novaConsulta);

            return new ConsultaRespostaController(resposta.saldo());
        } catch (HttpServerErrorException ex){
            var messageError = "Erro ao realizar chamada a API Externa";
            log.error(messageError);
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, messageError);
        }
    }
}
