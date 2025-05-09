package com.example.mechanic.conserto;

import com.example.mechanic.mecanico.model.DadosMecanico;
import com.example.mechanic.veiculo.model.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String entrada,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String saida,
        @NotNull
        @Valid
        DadosMecanico mecanico,
        @NotNull
        @Valid
        DadosVeiculo veiculo
) {
}
