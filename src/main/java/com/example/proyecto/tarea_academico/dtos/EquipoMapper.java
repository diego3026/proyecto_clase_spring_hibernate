package com.example.proyecto.tarea_academico.dtos;

import org.mapstruct.Mapper;

import com.example.proyecto.tarea_academico.entities.Equipo;

@Mapper(
    componentModel = "spring"
)
public interface EquipoMapper {
    EquipoDto equipoToEquipoDto(Equipo equipo);
    Equipo equipoDtoToEquipo(EquipoDto equipoDto);
}
