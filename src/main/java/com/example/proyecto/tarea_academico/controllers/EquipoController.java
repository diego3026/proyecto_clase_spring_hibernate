package com.example.proyecto.tarea_academico.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.proyecto.tarea_academico.entities.Equipo;
import com.example.proyecto.tarea_academico.services.EquipoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/equipos")
    public ResponseEntity<List<Equipo>> findEquipos(@RequestParam(required = false) String nombre) {
        List<Equipo> listEquipo = equipoService.findAllEquipos();

        if (nombre!=null) {
            List<Equipo> equipos = equipoService.findByNombre(nombre);
            if (equipos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(equipos);
        }
        return ResponseEntity.ok().body(listEquipo);
    }

    @PostMapping("/equipos")
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo equipo) {
        Equipo equipoCreado = equipoService.createEquipo(equipo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(equipoCreado.getIdEquipo())
                .toUri();

        return ResponseEntity.created(location).body(equipoCreado);
    }

    @PutMapping("/equipos/{id}")
    public ResponseEntity<Equipo> update(@PathVariable Long id, @RequestBody Equipo updatedEquipo) {
        Optional<Equipo> equipo = equipoService.updateEquipo(id, updatedEquipo);

        return equipo.map(equipoUpdateInDb -> ResponseEntity.ok().body(equipoUpdateInDb))
                .orElseGet(() -> {
                    Equipo equipoCreado = equipoService.createEquipo(updatedEquipo);
                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(equipoCreado.getIdEquipo())
                            .toUri();

                    return ResponseEntity.created(location).body(equipoCreado);
                });
    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<Equipo> deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }

    // @GetMapping("/equiposPorNombre")
    // public ResponseEntity<List<Equipo>> findEquiposByNombre(@RequestParam String nombre) {
    //     List<Equipo> equipos = equipoService.findByNombre(nombre);

    //     if (equipos.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok().body(equipos);
    // }
}
