package com.example.data.dto;

import com.example.data.models.Estudiante;

public record GetEstudianteDto(
        Long id,
        String nombre
) {

    public static GetEstudianteDto of(Estudiante estudiante) {
        return new GetEstudianteDto(
                estudiante.getId(),
                estudiante.getNombre()
        );
    }
}
