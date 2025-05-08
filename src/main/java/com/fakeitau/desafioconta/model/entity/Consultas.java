package com.fakeitau.desafioconta.model.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String idConta;
    private String agencia;
    private String conta;
    private String dac;
    private String idCliente;
    private String saldo;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public UUID getId() { return id; }

    public String getIdConta() { return idConta; }
    public void setIdConta(String idConta) { this.idConta = idConta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getConta() { return conta; }
    public void setConta(String conta) { this.conta = conta; }

    public String getDac() { return dac; }
    public void setDac(String dac) { this.dac = dac; }

    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }

    public String getSaldo() { return saldo; }
    public void setSaldo(String saldo) { this.saldo = saldo; }

}
