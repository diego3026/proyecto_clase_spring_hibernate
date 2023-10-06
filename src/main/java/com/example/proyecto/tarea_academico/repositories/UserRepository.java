package com.example.proyecto.tarea_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.tarea_academico.entities.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
}