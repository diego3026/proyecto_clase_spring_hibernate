package com.example.proyecto.tarea_academico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto.tarea_academico.entities.Equipo;
import com.example.proyecto.tarea_academico.repositories.EquipoRepository;

@Service
public class EquipoService {
    private EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> findEquipos(){
        return equipoRepository.findAll();
    }

    public List<Equipo> findByIdEquipo(Long id){
        return equipoRepository.findByIdEquipo(id);
    }

    public List<Equipo> findByNombre(String nombre){
        return equipoRepository.findByNombre(nombre);
    }
}
