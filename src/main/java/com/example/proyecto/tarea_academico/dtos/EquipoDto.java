package com.example.proyecto.tarea_academico.dtos;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipoDto {
    private Long idEquipo;
    
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "La bandera no puede estar vacia")
    @URL
    private String bandera;

    @NotBlank(message = "El director tecnico no puede estar vacio")
    private String directorTecnico;
}   
 