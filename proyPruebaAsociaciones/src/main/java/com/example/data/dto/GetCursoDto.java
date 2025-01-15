package com.example.data.dto;

import com.example.data.models.Curso;

public record GetCursoDto(
        Long id,
        String nombre
) {
    public static GetCursoDto of(Curso curso) {
        return new GetCursoDto(curso.getId(), curso.getNombre());
    }
}
