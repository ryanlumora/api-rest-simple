package com.example.mecanic.veiculo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank
        @NotNull
        String marca,
        @NotBlank
        @NotNull
        String modelo,
        String cor,
        @NotBlank
        @Pattern(regexp = "\\d{4}$")
        String ano) {
}
