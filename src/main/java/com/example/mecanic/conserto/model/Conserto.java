package com.example.mecanic.conserto.model;

import com.example.mecanic.mecanico.model.Mecanico;
import com.example.mecanic.veiculo.model.Veiculo;
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

    public Conserto(DadosConserto dados){
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }
}
