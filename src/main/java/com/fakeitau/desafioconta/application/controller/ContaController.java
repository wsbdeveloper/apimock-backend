package com.fakeitau.desafioconta.application.controller;


import com.fakeitau.desafioconta.service.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping("/{idConta}")
    public ResponseEntity buscarDadosConta(@PathVariable String idConta){
        return ResponseEntity.ok(contaService.consultarConta(idConta));
    }
}
