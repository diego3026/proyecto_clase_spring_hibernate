package com.example.proyecto.tarea_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.proyecto.tarea_academico.entities.Partido;
import java.time.LocalDate;
import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findPartidoByFecha(LocalDate fecha);
    @Query("SELECT p FROM Partido p WHERE (p.local.idEquipo = ?1 OR p.visitante.idEquipo = ?1)")
    List<Partido> findPartidoByLocalOrVisitante(Long idEquipo);

}
