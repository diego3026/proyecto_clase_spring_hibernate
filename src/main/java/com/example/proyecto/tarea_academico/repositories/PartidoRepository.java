package com.example.proyecto.tarea_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.proyecto.tarea_academico.entities.Partido;
import java.time.LocalDate;
import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findPartidoByFecha(LocalDate fecha);
    List<Partido> findByIdPartido(Long idPartido);
    @Query("SELECT p FROM Partido p WHERE p.idPartido = ?1 AND (p.local.idEquipo = ?2 OR p.visitante.idEquipo = ?2)")
    List<Partido> findPartidoByLocalOrVisitante(Long idEquipo);

}
