package com.vagas.remotinho.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmpresaRequest
         (@NotBlank
          String nome,
          @Pattern(regexp = "\\d{14}")
          String cnpj,
          @NotBlank
          @Email
          String email) {
}
