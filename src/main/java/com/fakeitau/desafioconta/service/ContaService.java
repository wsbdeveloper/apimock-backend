package com.fakeitau.desafioconta.service;

import com.fakeitau.desafioconta.domain.Conta;
import org.springframework.stereotype.Service;

@Service
public class ContaService {


    public Conta consultarConta(String idConta){
        return new Conta(
                "123",
                "AG123",
                "23615",
                "2",
                "123444332123",
                "500"
        );
    }
}
