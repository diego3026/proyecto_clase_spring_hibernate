package com.example.proyecto.tarea_academico.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PartidoDto {
    private Long idPartido;

    @NotBlank(message = "La fecha no puede estar vacia")
    private LocalDate fecha;

    @NotBlank(message = "El estadio no puede estar vacio")
    private String estadio;

    @NotBlank(message = "El arbitro no puede estar vacio")
    private String arbitroPrincipal;
    
    private EquipoDto local;
    private EquipoDto visitante;
    private ResultadoDto marcardor;
}
