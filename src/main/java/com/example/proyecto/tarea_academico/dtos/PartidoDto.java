package com.example.proyecto.tarea_academico.dtos;

import java.time.LocalDate;
 
import lombok.Data;

@Data
public class PartidoDto {
    private Long idPartido;
    private LocalDate fecha;
    private String estadio;
    private String arbitroPrincipal;
    private EquipoDto local;
    private EquipoDto visitante;
    private ResultadoDto marcardor;
}
