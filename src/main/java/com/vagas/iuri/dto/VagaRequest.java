package com.vagas.iuri.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record VagaRequest
        (@NotBlank
         @Size(max = 100)
         String cargo,
         @NotBlank
         @Size(max = 100)
         String localizacao,
         @NotNull
         @FutureOrPresent
         LocalDate dataPublicacao,
         @NotBlank
         @Pattern(regexp = "https?://.*")
         String link,
         @NotNull
         Integer empresaId) {
}
