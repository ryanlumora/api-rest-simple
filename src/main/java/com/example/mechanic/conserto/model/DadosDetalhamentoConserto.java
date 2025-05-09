package com.example.mechanic.conserto.model;

import com.example.mechanic.mecanico.model.Mecanico;
import com.example.mechanic.veiculo.model.Veiculo;

public record DadosDetalhamentoConserto(
        Long id,
        String entrada,
        String saida,
        Mecanico mecanico,
        Veiculo veiculo
) { public  DadosDetalhamentoConserto(Conserto conserto){
    this(conserto.getId(),
            conserto.getEntrada(),
            conserto.getSaida(),
            conserto.getMecanico(),
            conserto.getVeiculo());
}
}
