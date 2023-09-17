package com.example.proyecto.tarea_academico.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.proyecto.tarea_academico.entities.Resultado;
import com.example.proyecto.tarea_academico.services.ResultadoService;

@RestController
@RequestMapping("api/v1")
public class ResultadoController {
    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping("/resultados")
    public ResponseEntity<List<Resultado>> findResultados() {
        List<Resultado> resultados = resultadoService.findResultados();

        return ResponseEntity.ok().body(resultados);
    }

    @PostMapping("/resultados")
    public ResponseEntity<Resultado> crearResultado(@RequestBody Resultado resultado) {
        Resultado resultadoNuevo = resultadoService.crearResultado(resultado);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resultadoNuevo.getIdResultado())
                .toUri();
        return ResponseEntity.created(location).body(resultadoNuevo);
    }

    @PutMapping("/resultado/{id}")
    public ResponseEntity<Resultado> updateResultado(@PathVariable Long id, @RequestBody Resultado resultadoUptade) {
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
