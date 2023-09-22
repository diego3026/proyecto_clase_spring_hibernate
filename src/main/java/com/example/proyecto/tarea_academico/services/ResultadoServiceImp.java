package com.example.proyecto.tarea_academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyecto.tarea_academico.entities.Resultado;
import com.example.proyecto.tarea_academico.repositories.ResultadoRepository;

@Service
public class ResultadoServiceImp implements ResultadoService {
    private ResultadoRepository resultadoRepository;

    public ResultadoServiceImp(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    @Override
    public List<Resultado> findResultados() {
        return resultadoRepository.findAll();
    }

    @Override
    public Optional<Resultado> findByIdResultados(Long idResultado) {
        return resultadoRepository.findById(idResultado);
    }

    @Override
    public Resultado crearResultado(Resultado resultado) {
        Resultado resultadoNuevo = new Resultado();
        resultadoNuevo.setGolLocal(resultado.getGolLocal());
        resultadoNuevo.setGolVisitantes(resultado.getGolVisitantes());
        resultadoNuevo.setNumeroDeTarjetasAmarillas(resultado.getNumeroDeTarjetasAmarillas());
        resultadoNuevo.setNumeroDeTarjetasRojas(resultado.getNumeroDeTarjetasRojas());
        resultadoNuevo.setPartido(resultado.getPartido());
        return resultadoRepository.save(resultadoNuevo);
    }

    @Override
    public Optional<Resultado> updateResultado(Long idResultado, Resultado newResultado) {
        Optional<Resultado> resultadoInDB = resultadoRepository.findById(idResultado);

        Optional<Resultado> resultadoUpdated = resultadoInDB.map(oldResultadoInDB -> {
            Resultado updated = oldResultadoInDB.updateWith(newResultado);
            return resultadoRepository.save(updated);
        });

        return resultadoUpdated;
    }

}
