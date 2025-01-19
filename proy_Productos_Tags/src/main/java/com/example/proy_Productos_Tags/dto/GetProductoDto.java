package com.example.proy_Productos_Tags.dto;

import com.example.proy_Productos_Tags.models.Producto;

public record GetProductoDto(Long id,
                             String nombre,
                             double precio,
                             GetCategoriaDto categoria
) {

    public static GetProductoDto of(Producto p) {
        return new GetProductoDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                GetCategoriaDto.of(p.getCategoria())
        );
    }
}
