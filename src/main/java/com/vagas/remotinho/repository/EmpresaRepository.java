package com.vagas.remotinho.repository;

import com.vagas.remotinho.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
