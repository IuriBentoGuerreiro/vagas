package com.vagas.iuri.repository;

import com.vagas.iuri.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
