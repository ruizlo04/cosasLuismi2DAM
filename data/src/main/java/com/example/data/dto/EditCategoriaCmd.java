package com.example.data.dto;

import com.example.data.models.Producto;

import java.util.List;

public record EditCategoriaCmd(
        String nombre,
        List<Producto> listaProductos
) {
}
