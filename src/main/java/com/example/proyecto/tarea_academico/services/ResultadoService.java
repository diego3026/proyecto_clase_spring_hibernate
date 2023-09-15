package com.example.proyecto.tarea_academico.services;

import java.util.List;

import com.example.proyecto.tarea_academico.entities.Resultado;
import com.example.proyecto.tarea_academico.repositories.ResultadoRepository;

public class ResultadoService {
    private ResultadoRepository resultadoRepository; 

    public ResultadoService(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    public List<Resultado> findResultados(){
        return resultadoRepository.findAll();
    }

    public List<Resultado> findByIdResultados(Long idResultado){
        return resultadoRepository.findByIdResultado(idResultado);
    }

}
