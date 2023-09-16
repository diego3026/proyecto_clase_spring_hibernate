package com.example.proyecto.tarea_academico.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.proyecto.tarea_academico.entities.Partido;
import com.example.proyecto.tarea_academico.repositories.PartidoRepository;

public class PartidoServiceImp implements PartidoService {
    private PartidoRepository partidoRep;

    public PartidoServiceImp(PartidoRepository partidoRep) {
        this.partidoRep = partidoRep;
    }

    @Override
    public List<Partido> findByIdPartidoAndFecha(Long idPartido, LocalDate fecha) {
        return partidoRep.findByIdPartidoAndFecha(idPartido, fecha);
    }

    @Override
    public Optional<Partido> findByIdPartido(Long id) {
        return partidoRep.findById(id);
    }

    @Override
    public List<Partido> findPartidos() {
        return partidoRep.findAll();
    }

    @Override
    public List<Partido> findByIdPartidoAndLocalOrVisitante(Long idPartido, Long idEquipo) {
        return partidoRep.findByIdPartidoAndLocalOrVisitante(idPartido, idEquipo);
    }

    @Override
    public Partido createPartido(Partido partido) {
        Partido partidoNuevo = new Partido();
        partidoNuevo.setArbitroPrincipal(partido.getArbitroPrincipal());
        partidoNuevo.setEstadio(partido.getEstadio());
        partidoNuevo.setFecha(partido.getFecha());
        partidoNuevo.setLocal(partido.getLocal());
        partidoNuevo.setMarcardor(partido.getMarcardor());
        partidoNuevo.setVisitante(partido.getVisitante());
        return partidoRep.save(partidoNuevo);
    }

    @Override
    public Optional<Partido> updatedPartido(Long idPartido, Partido newPartido) {
        Optional<Partido> partidoInDB = partidoRep.findById(idPartido);

        Optional<Partido> partidoUpdated = partidoInDB.map(oldPartidoInDB -> {
            Partido updated = oldPartidoInDB.updateWith(newPartido);
            return partidoRep.save(updated);
        });

        return partidoUpdated;
    }

}
