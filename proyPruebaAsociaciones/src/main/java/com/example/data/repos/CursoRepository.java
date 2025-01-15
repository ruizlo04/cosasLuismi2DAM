package com.example.data.repos;

import com.example.data.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository
        extends JpaRepository<Curso, Long> {
}
