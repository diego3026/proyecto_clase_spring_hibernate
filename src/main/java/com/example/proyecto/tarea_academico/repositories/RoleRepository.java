package com.example.proyecto.tarea_academico.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.tarea_academico.entities.ERoles;
import com.example.proyecto.tarea_academico.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERoles name);
}
