package com.fakeitau.desafioconta.service;

import com.fakeitau.desafioconta.application.controller.web.dtos.MockResponse;
import com.fakeitau.desafioconta.domain.Conta;
import com.fakeitau.desafioconta.infrastructure.client.MockApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContaService {

    private static final Logger log = LoggerFactory.getLogger(ContaService.class);
    private MockApiClient clientMock;

    public ContaService(MockApiClient clientMock){
        this.clientMock = clientMock;
    }


    public MockResponse consultarConta(String idConta){
        try{
            log.info("Consultando conta no serviço externo com ID: {}", idConta);
            MockResponse resposta = clientMock.consultaContaExterno(idConta);
            return resposta;
        } catch (HttpServerErrorException ex){
            var messageError = "Erro ao realizar chamada a API Externa";
            log.error(messageError);
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, messageError);
        }
    }
}
