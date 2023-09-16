package com.example.proyecto.tarea_academico.services;

import java.util.List;
import java.util.Optional;

import com.example.proyecto.tarea_academico.entities.Equipo;
import com.example.proyecto.tarea_academico.repositories.EquipoRepository;

public class EquipoServiceImpl implements EquipoService{
    private EquipoRepository equipoRepository;
    
    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> findAllEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> findbyIdEquipo(Long id) {
        return equipoRepository.findById(id);
    }

    @Override
    public List<Equipo> findByNombre(String nombre) {
        return equipoRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Equipo> updateEquipo(Long idEquipo, Equipo newEquipo) {
        Optional<Equipo> equipoInDB = equipoRepository.findById(idEquipo);

        Optional<Equipo> equipoUpdated = equipoInDB.map(oldEquipoInDB->{
            Equipo updated = oldEquipoInDB.updateWith(newEquipo);
            return equipoRepository.save(updated);
        });

        return equipoUpdated;
    }

    @Override
    public Equipo createEquipo(Equipo equipo) {
        Equipo equipoNuevo = new Equipo();
        equipoNuevo.setNombre(equipo.getNombre());
        equipoNuevo.setDirectorTecnico(equipo.getDirectorTecnico());
        equipoNuevo.setBandera(equipo.getDirectorTecnico());
        return equipoRepository.save(equipoNuevo);
    }

    @Override
    public void deleteEquipo(Long idEquipo) {
        equipoRepository.deleteById(idEquipo); 
    }
    
}
