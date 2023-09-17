package com.example.proyecto.tarea_academico.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.proyecto.tarea_academico.entities.*;
import com.example.proyecto.tarea_academico.services.PartidoService;

@RestController
@RequestMapping("api/v1")
public class PartidoController {
    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping("/partidos")
    public ResponseEntity<List<Partido>> findPartidos(@RequestParam(required = false) LocalDate fecha, @RequestParam(required = false) Long idEquipo) {
        List<Partido> partidos = partidoService.findPartidos();

        if (fecha != null && idEquipo == null) {
            List<Partido> partidosPorFecha = partidoService.findPartidoByFecha(fecha);
            if (partidosPorFecha.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(partidosPorFecha);
        }
        if (fecha == null && idEquipo != null) {
            List<Partido> partidosPorEquipo = partidoService.findPartidoByLocalOrVisitante(idEquipo);
            if (partidosPorEquipo.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(partidosPorEquipo);
        }

        return ResponseEntity.ok().body(partidos);
    }

    @PostMapping("/partidos")
    public ResponseEntity<Partido> crearPartido(@RequestBody Partido partido) {
        Partido partidoCreado = partidoService.createPartido(partido);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(partidoCreado.getIdPartido())
                .toUri();

        return ResponseEntity.created(location).body(partidoCreado);
    }

    // @PatchMapping("/partidos/{id}")
    // public ResponseEntity<Partido> patchPartido(@PathVariable Long id) {

    // }

}
