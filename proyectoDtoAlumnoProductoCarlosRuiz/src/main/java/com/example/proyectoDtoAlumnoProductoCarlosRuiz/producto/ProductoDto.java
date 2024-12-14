package com.example.proyectoDtoAlumnoProductoCarlosRuiz.producto;

public record ProductoDto(
        String nombre,
        double pvp,
        String imagen,
        String categoria
) {

    public static ProductoDto ofProducto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().get(0),
                producto.getCategoria().getNombre()
        );
    }
}
