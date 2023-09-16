package com.example.proyecto.tarea_academico.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEquipo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String bandera;

    @Column(nullable = false)
    private String directorTecnico;

    @OneToMany(mappedBy = "local")
    private Set<Partido> partidosLocal;

    @OneToMany(mappedBy = "visitante")
    private Set<Partido> partidosVisitante;

    public Equipo updateWith(Equipo newEquipo) {
        return new Equipo(this.idEquipo,newEquipo.getNombre(),
                                        newEquipo.getBandera(),
                                        newEquipo.getDirectorTecnico(),
                                        newEquipo.getPartidosLocal(),
                                        newEquipo.getPartidosVisitante());
    }
}
