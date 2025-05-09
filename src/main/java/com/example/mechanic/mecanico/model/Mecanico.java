package com.example.mechanic.mecanico.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "mecanicos")
@Entity(name = "Mecanico")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String experiencia;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void atualizarInformacoes(DadosMecanico dados) {
        if(nome != null) this.nome = dados.nome();
        if(experiencia != null) this.experiencia = dados.experiencia();
    }
}
