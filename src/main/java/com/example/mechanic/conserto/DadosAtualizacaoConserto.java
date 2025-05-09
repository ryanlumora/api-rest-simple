package com.example.mechanic.conserto;

import com.example.mechanic.mecanico.model.DadosMecanico;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String saida,
        DadosMecanico mecanico
) {
}
