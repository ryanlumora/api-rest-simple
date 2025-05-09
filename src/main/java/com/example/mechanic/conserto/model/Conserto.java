package com.example.mechanic.conserto.model;

import com.example.mechanic.mecanico.model.Mecanico;
import com.example.mechanic.veiculo.model.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entrada;
    private String saida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;
    private boolean ativo;

    public Conserto(DadosConserto dados){
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        this.saida = dados.saida();
        if(dados.mecanico() != null) {
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}

