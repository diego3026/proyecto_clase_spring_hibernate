package com.example.proyecto.tarea_academico.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.proyecto.tarea_academico.entities.Equipo;

@Service
public interface EquipoService {
    List<Equipo> findAllEquipos();
    Optional<Equipo> findbyIdEquipo(Long id);
    List<Equipo> findByNombre(String nombre);
    Optional<Equipo> updateEquipo(Long idEquipo, Equipo equipo);
    Equipo createEquipo(Equipo equipo);
    void deleteEquipo(Long idEquipo);
}
