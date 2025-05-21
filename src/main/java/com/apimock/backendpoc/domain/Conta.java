package com.apimock.backendpoc.domain;

public record Conta(
        String id,
        String agencia,
        String conta,
        String dac,
        String idCliente,
        String saldo
) {
}
