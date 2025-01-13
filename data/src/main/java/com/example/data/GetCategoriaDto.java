package com.example.data;

public record GetCategoriaDto(Long id, String nombre) {

    public static GetCategoriaDto of(Categoria category) {
        return new GetCategoriaDto(category.getId(), category.getNombre());
    }
}
