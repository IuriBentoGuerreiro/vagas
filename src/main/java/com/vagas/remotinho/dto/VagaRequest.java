package com.vagas.remotinho.dto;

import java.time.LocalDate;

public record VagaRequest
        (String cargo,
         String localizacao,
         LocalDate dataPublicacao,
         String link,
         Integer empresaId) {
}
