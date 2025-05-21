package com.apimock.backendpoc.application.controller;


import com.apimock.backendpoc.service.ContaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    private static final Logger log = LoggerFactory.getLogger(ContaController.class);

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping("/{idConta}")
    public ResponseEntity buscarDadosConta(@PathVariable String idConta) {

        var resultado = contaService.consultarConta(idConta);

        if (resultado == null) {
            log.error("Consulta com id fornecido não teve sucesso!");
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Consulta com id fornecido não teve sucesso!");
        }
        log.info("Informação da conta obtida com sucesso! id={} | saldo={}", idConta, resultado.saldo());
        return ResponseEntity.ok(resultado);
    }
}
