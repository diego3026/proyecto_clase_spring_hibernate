package com.example.proyecto.tarea_academico.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "resultados")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idResultado;

    @Column(nullable = false)
    private int golVisitante;

    @Column(nullable = false)
    private int golLocal;

    @Column(nullable = false)
    private int numeroDeTarjetasRojas;

    @Column(nullable = false)
    private int numeroDeTarjetasAmarrillas;

    @OneToOne(mappedBy = "marcardor")
    private Partido partido;
}
