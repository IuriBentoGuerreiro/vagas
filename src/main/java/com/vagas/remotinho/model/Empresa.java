package com.vagas.remotinho.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "empresa")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    private String email;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<Vaga> vaga;

    public Empresa(Integer id){
        this.id = id;
    }
}
