package com.example.mechanic.conserto.model;

public record DadosListagemConserto(
        Long id,
        String entrada,
        String saida,
        String mecanico,
        String marca,
        String modelo
) {
    public DadosListagemConserto(Conserto conserto){
        this(conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}