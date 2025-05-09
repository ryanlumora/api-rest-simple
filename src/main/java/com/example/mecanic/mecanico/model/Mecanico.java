package com.example.mecanic.mecanico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
