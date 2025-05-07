package com.fakeitau.desafioconta.domain;

public record Conta(
        String id,
        String agencia,
        String conta,
        String dac,
        String idCliente,
        String saldo
) {
}
