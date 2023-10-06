package com.example.proyecto.tarea_academico.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "partidos")
@AllArgsConstructor
@NoArgsConstructor
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPartido;

    @NotBlank(message = "La fecha no puede estar vacia")
    @Column(nullable = false)
    private LocalDate fecha; 

    @NotBlank(message = "El estadio no puede estar vacio")
    @Column(nullable = false)
    private String estadio;

    @NotBlank(message = "El arbitro no puede estar vacio")
    @Column(nullable = false)
    private String arbitroPrincipal;

    @ManyToOne
    @JoinColumn(name = "idEquipoLocal")
    private Equipo local;

    @ManyToOne
    @JoinColumn(name = "idEquipoVisitante")
    private Equipo visitante;
 
    @OneToOne(optional = false)
    @JoinColumn(name = "idResultado", referencedColumnName = "idResultado")
    private Resultado marcardor;

    public Partido updateWith(Partido partido) {
        return new Partido(this.idPartido, partido.getFecha(), partido.getEstadio(), partido.getArbitroPrincipal(),
                partido.getLocal(), partido.getVisitante(), partido.getMarcardor());
    }

}
