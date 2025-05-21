package com.apimock.backendpoc.infrastructure.repository;

import com.apimock.backendpoc.model.entity.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consultas, Long> {
}
