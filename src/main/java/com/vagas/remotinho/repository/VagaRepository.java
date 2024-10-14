package com.vagas.remotinho.repository;

import com.vagas.remotinho.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {

    List<Vaga> findByLocalizacaoContainingIgnoreCase(String localizacao);

    List<Vaga> findByCargoContainingIgnoreCase(String cargo);


}
