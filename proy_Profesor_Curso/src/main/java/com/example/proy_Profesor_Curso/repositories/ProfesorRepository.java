package com.example.proy_Profesor_Curso.repositories;

import com.example.proy_Profesor_Curso.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
