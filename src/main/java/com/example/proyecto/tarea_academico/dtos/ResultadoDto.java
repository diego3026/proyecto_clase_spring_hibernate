package com.example.proyecto.tarea_academico.dtos;

import lombok.Data;

@Data
public class ResultadoDto {
    private Long idResultado;
    private int golVisitantes;
    private int golLocal;
    private int numeroDeTarjetasRojas;
    private int numeroDeTarjetasAmarillas;
}
