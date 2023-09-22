package com.example.proyecto.tarea_academico.dtos;

import org.mapstruct.Mapper;

import com.example.proyecto.tarea_academico.entities.Partido;

@Mapper(
    componentModel = "spring"
)
public interface PartidoMapper {
    Partido partidoDtoToPartido(PartidoDto partidoDto);
    PartidoDto partidoToPartidoDto(Partido partido);
}
