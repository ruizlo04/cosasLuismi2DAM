package com.example.data.dto;

import com.example.data.models.Categoria;

public record GetCategoriaDto(Long id, String nombre) {

    public static GetCategoriaDto of(Categoria category) {
        return new GetCategoriaDto(category.getId(), category.getNombre());
    }
}
