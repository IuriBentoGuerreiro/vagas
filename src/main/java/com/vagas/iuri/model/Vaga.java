package com.vagas.iuri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "vaga")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cargo;
    private String localizacao;
    private LocalDate dataPublicacao;
    private String link;

    @ManyToOne
    @JoinColumn(name = "empresa_fk")
    private Empresa empresa;
}
