package com.fakeitau.desafioconta.infrastructure.client.repository;

import com.fakeitau.desafioconta.model.entity.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consultas, Long> {
}
