package com.example.proyecto.tarea_academico.dtos;

import org.mapstruct.Mapper;

import com.example.proyecto.tarea_academico.entities.Resultado;

@Mapper(
    componentModel = "spring"
)
public interface ResultadoMapper {
    Resultado ResultadoDtoToResultado(ResultadoDto resultadoDto);
    ResultadoDto resultadoToResultadoDto(Resultado resultado);
}
