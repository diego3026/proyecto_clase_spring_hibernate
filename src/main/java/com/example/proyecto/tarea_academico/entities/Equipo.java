package com.example.proyecto.tarea_academico.entities;

import java.util.*;

import org.hibernate.validator.constraints.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La bandera no puede estar vacia")
    @URL
    @Column(nullable = false)
    private String bandera;

    @NotBlank(message = "El director tecnico no puede estar vacio")
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
