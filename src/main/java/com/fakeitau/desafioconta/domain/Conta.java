package com.fakeitau.desafioconta.domain;

public record Conta(
        String idConta,
        String agencia,
        String conta,
        String dac,
        String idCliente,
        String saldo
) {
}
