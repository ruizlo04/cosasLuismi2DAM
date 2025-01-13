package com.example.data;

public record GetProductoDto(
        Long id,
        String nombre,
        double precio,
        Categoria categoria
) {

    public static GetProductoDto of(Producto producto) {
        return new GetProductoDto(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCategoria()
        );
    }
}
