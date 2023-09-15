package com.example.proyecto.tarea_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.tarea_academico.entities.Resultado;
import java.util.List;


public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    List<Resultado> findByIdResultado(long idResultado);
}
