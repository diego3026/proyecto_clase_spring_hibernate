package com.example.proyecto.tarea_academico.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "partidos")
@AllArgsConstructor
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPartido;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String estadio;
    
    @Column(nullable = false)
    private String arbitroPrincipal;

    @ManyToOne
    @JoinColumn(name = "idEquipoLocal")
    private Equipo local;

    @ManyToOne
    @JoinColumn(name = "idEquipoVisitante")
    private Equipo visitante;

    @OneToOne(optional = false)
    @JoinColumn(name = "idResultado",referencedColumnName = "idResultado")
    private Resultado marcardor;

}
