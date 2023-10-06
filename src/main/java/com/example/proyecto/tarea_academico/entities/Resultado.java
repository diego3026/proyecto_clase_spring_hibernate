package com.example.proyecto.tarea_academico.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    @Column(nullable = false)
    private int golVisitantes;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    @Column(nullable = false)
    private int golLocal;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    @Column(nullable = false)
    private int numeroDeTarjetasRojas;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    @Column(nullable = false)
    private int numeroDeTarjetasAmarillas;

    @NotBlank(message = "No puede estar vacio")
    @OneToOne(mappedBy = "marcardor")
    private Partido partido;

    public Resultado updateWith(Resultado Resultado) {
        return new Resultado(this.idResultado, Resultado.getGolVisitantes(), Resultado.getGolLocal(),
                Resultado.getNumeroDeTarjetasRojas(), Resultado.getNumeroDeTarjetasAmarillas(),
                Resultado.getPartido());
    }
}
