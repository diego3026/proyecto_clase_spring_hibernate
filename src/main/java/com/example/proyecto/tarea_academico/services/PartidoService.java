package com.example.proyecto.tarea_academico.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.proyecto.tarea_academico.entities.Partido;

public interface PartidoService {
    List<Partido> findPartidoByFecha(LocalDate fecha);
    Optional<Partido> findByIdPartido(Long id);
    List<Partido> findPartidos();
    Partido createPartido(Partido partido);
    Optional<Partido> updatedPartido(Long idPartido, Partido partido);
    List<Partido> findPartidoByLocalOrVisitante(Long idEquipo);
}
