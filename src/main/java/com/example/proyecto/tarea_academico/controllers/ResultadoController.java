package com.example.proyecto.tarea_academico.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.proyecto.tarea_academico.dtos.ResultadoDto;
import com.example.proyecto.tarea_academico.dtos.ResultadoMapper;
import com.example.proyecto.tarea_academico.entities.Resultado;
import com.example.proyecto.tarea_academico.services.ResultadoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("api/v1")
@Validated
public class ResultadoController {
    private final ResultadoService resultadoService;
    private final ResultadoMapper resultadoMapper;

    public ResultadoController(ResultadoService resultadoService, ResultadoMapper resultadoMapper) {
        this.resultadoService = resultadoService;
        this.resultadoMapper = resultadoMapper;
    }

    @GetMapping("/resultados")
    public ResponseEntity<List<ResultadoDto>> findResultados() {
        List<Resultado> resultados = resultadoService.findResultados();
        List<ResultadoDto> resultadosDto = new ArrayList<>();
        resultadosDto = resultados.stream().map(resultado -> resultadoMapper.resultadoToResultadoDto(resultado)).collect(Collectors.toList());

        return ResponseEntity.ok().body(resultadosDto);
    }

    @PostMapping("/resultados")
    public ResponseEntity<Resultado> crearResultado(@RequestBody @Valid Resultado resultado) {
        Resultado resultadoNuevo = resultadoService.crearResultado(resultado);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resultadoNuevo.getIdResultado())
                .toUri();
        return ResponseEntity.created(location).body(resultadoNuevo);
    }

    @PutMapping("/resultados/{id}")
    public ResponseEntity<Resultado> updateResultado(@PathVariable @Min(1) Long id, @RequestBody @Valid Resultado resultadoUptade) {
        Optional<Resultado> resultado = resultadoService.updateResultado(id, resultadoUptade);

        return resultado.map(resultadoUpdateInDb -> ResponseEntity.ok().body(resultadoUpdateInDb))
                .orElseGet(() -> {
                    Resultado resultadoNuevo = resultadoService.crearResultado(resultadoUptade);

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(resultadoNuevo.getIdResultado())
                            .toUri();
                    return ResponseEntity.created(location).body(resultadoNuevo);
                });
    }

}
