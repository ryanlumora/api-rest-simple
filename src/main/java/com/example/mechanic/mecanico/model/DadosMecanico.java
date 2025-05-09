package com.example.mechanic.mecanico.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosMecanico(
        @NotBlank
        @NotNull
        String nome,
        String experiencia
) {
}
