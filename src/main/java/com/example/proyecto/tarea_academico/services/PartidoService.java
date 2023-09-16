package com.example.proyecto.tarea_academico.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyecto.tarea_academico.entities.Partido;

@Service
public interface PartidoService {
    List<Partido> findByIdPartidoAndFecha(Long idPartido, LocalDate fecha);
    Optional<Partido> findByIdPartido(Long id);
    List<Partido> findPartidos();
    Partido createPartido(Partido partido);
    Optional<Partido> updatedPartido(Long idPartido, Partido partido);
    List<Partido> findByIdPartidoAndLocalOrVisitante(Long idPartido, Long idEquipo);
}
