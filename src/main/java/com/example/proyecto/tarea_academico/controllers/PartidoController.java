package com.example.proyecto.tarea_academico.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.proyecto.tarea_academico.dtos.PartidoDto;
import com.example.proyecto.tarea_academico.dtos.PartidoMapper;
import com.example.proyecto.tarea_academico.entities.*;
import com.example.proyecto.tarea_academico.services.PartidoService;

@RestController
@RequestMapping("api/v1")
public class PartidoController {
    private final PartidoService partidoService;
    private final PartidoMapper partidoMapper;

    public PartidoController(PartidoService partidoService, PartidoMapper partidoMapper) {
        this.partidoService = partidoService;
        this.partidoMapper = partidoMapper;
    }

    @GetMapping("/partidos")
    public ResponseEntity<List<PartidoDto>> findPartidos(@RequestParam(required = false) LocalDate fecha,
            @RequestParam(required = false) Long idEquipo) {
        List<Partido> partidos = partidoService.findPartidos();
        List<PartidoDto> partidosDto = new ArrayList<>();
        partidosDto  = partidos.stream().map(partido -> partidoMapper.partidoToPartidoDto(partido)).collect(Collectors.toList());

        if (fecha != null && idEquipo == null) {
            List<Partido> partidosPorFecha = partidoService.findPartidoByFecha(fecha);
            List<PartidoDto> partidosDtoPorFecha = new ArrayList<>();
            partidosDtoPorFecha  = partidosPorFecha.stream().map(partido -> partidoMapper.partidoToPartidoDto(partido)).collect(Collectors.toList());

            if (partidosPorFecha.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(partidosDtoPorFecha);
        }
        if (fecha == null && idEquipo != null) {
            List<Partido> partidosPorEquipo = partidoService.findPartidoByLocalOrVisitante(idEquipo);
            List<PartidoDto> partidosDtoPorEquipo = new ArrayList<>();
            partidosDtoPorEquipo  = partidosPorEquipo.stream().map(partido -> partidoMapper.partidoToPartidoDto(partido)).collect(Collectors.toList());

            if (partidosPorEquipo.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(partidosDtoPorEquipo);
        }

        return ResponseEntity.ok().body(partidosDto);
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

    @PutMapping("/partidos/{id}")
    public ResponseEntity<PartidoDto> updatePartido(@PathVariable Long id, @RequestBody Partido partidoUpdate) {
        Optional<Partido> partido = partidoService.updatedPartido(id, partidoUpdate);

        return partido.map(partidoUpdateInDb -> ResponseEntity.ok().body(partidoMapper.partidoToPartidoDto(partidoUpdateInDb)))
                .orElseGet(() -> {
                    Partido partidoCreado = partidoService.createPartido(partidoUpdate);
                    
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(partidoMapper.partidoToPartidoDto(partidoCreado).getIdPartido())
                            .toUri();

                    return ResponseEntity.created(location).body(partidoMapper.partidoToPartidoDto(partidoCreado));
                });
    }
}
