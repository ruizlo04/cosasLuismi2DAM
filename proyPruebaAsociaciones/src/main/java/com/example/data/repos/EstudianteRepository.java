package com.example.data.repos;

import com.example.data.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository
        extends JpaRepository<Estudiante, Long> {
}
