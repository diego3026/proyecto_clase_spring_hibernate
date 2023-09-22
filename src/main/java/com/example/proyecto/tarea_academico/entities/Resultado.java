package com.example.proyecto.tarea_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resultados")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idResultado;

    @Column(nullable = false)
    private int golVisitantes;

    @Column(nullable = false)
    private int golLocal;

    @Column(nullable = false)
    private int numeroDeTarjetasRojas;

    @Column(nullable = false)
    private int numeroDeTarjetasAmarillas;

    @OneToOne(mappedBy = "marcardor")
    private Partido partido;

    public Resultado updateWith(Resultado Resultado) {
        return new Resultado(this.idResultado, Resultado.getGolVisitantes(), Resultado.getGolLocal(),
                Resultado.getNumeroDeTarjetasRojas(), Resultado.getNumeroDeTarjetasAmarillas(),
                Resultado.getPartido());
    }
}
