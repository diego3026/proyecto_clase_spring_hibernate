package com.example.proyecto.tarea_academico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyecto.tarea_academico.entities.Equipo;


public interface EquipoRepository extends JpaRepository<Equipo, Long>{
    List<Equipo> findByNombre(String nombre); 
    List<Equipo> findByIdEquipo(long idEquipo);
}
