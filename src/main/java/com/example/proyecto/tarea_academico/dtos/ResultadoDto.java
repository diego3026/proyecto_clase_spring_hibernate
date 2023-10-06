package com.example.proyecto.tarea_academico.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ResultadoDto {
    private Long idResultado;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    private int golVisitantes;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    @NotEmpty
    private int golLocal;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    private int numeroDeTarjetasRojas;

    @PositiveOrZero
    @NotBlank(message = "No puede estar vacio")
    private int numeroDeTarjetasAmarillas;
}
