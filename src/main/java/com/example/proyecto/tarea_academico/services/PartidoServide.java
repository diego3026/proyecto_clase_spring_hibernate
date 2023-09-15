package com.example.proyecto.tarea_academico.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto.tarea_academico.entities.Partido;
import com.example.proyecto.tarea_academico.repositories.PartidoRepository;

@Service
public class PartidoServide {
    private PartidoRepository partidoRep;

    public PartidoServide(PartidoRepository partidoRep) {
        this.partidoRep = partidoRep;
    }
    
    public List<Partido> findByIdPartidoAndFecha(Long idPartido, LocalDate fecha){
        return partidoRep.findByIdPartidoAndFecha(idPartido, fecha);
    }

    public List<Partido> findByIdPartido(Long id){
        return partidoRep.findByIdPartido(id);
    }

    public List<Partido> findPartidos(){
        return partidoRep.findAll();
    }

    public List<Partido> findByIdPartidoAndLocalOrVisitante(Long idPartido, Long idEquipo){
        return partidoRep.findByIdPartidoAndLocalOrVisitante(idPartido, idEquipo);
    }
}
