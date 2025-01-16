package com.example.data.service;


import com.example.data.dto.EditCursoDto;
import com.example.data.models.Curso;
import com.example.data.repos.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoService {
    
    private final CursoRepository cursoRepository;

    public List<Curso> findAll() {
        List<Curso> cursos = cursoRepository.findAll();
        if (cursos.isEmpty()) {
            throw new EntityNotFoundException("Curso no encontrado");
        }
        return cursos;
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado"));
    }

    public Curso save(EditCursoDto curso) {
        return cursoRepository.save(Curso.builder().nombre(curso.nombre()).build());
    }

    public Curso edit(EditCursoDto curso, Long id) {
        return cursoRepository.findById(id).map(
                old -> {
                    old.setNombre(curso.nombre());
                    return cursoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay curso con ese id"));
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
