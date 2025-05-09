package com.example.mecanic.conserto.model;

public record DadosListagemConserto(
        String entrada,
        String saida,
        String mecanico,
        String marca,
        String modelo
) {
    public DadosListagemConserto(Conserto conserto){
        this(conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
