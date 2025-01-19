package com.example.proy_Productos_Tags.dto;

import com.example.proy_Productos_Tags.models.Categoria;

public record GetCategoriaDto(Long id, String nombre) {

    public static GetCategoriaDto of(Categoria categoria) {
        return new GetCategoriaDto(categoria.getId(), categoria.getNombre());
    }
}
