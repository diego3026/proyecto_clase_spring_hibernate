package com.example.proyecto.tarea_academico.services;

import java.util.List;
import java.util.Optional;

import com.example.proyecto.tarea_academico.entities.Resultado;

public interface ResultadoService {
    List<Resultado> findResultados();
    Optional<Resultado> findByIdResultados(Long idResultado);
    Resultado crearResultado(Resultado resultado);
    Optional<Resultado> updateResultado(Long idResultado, Resultado resultado); 
}
