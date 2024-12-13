package com.example.proyectoDtoAlumnoProductoCarlosRuiz.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    private Long id;
    private String nombre;
    private Double desc;
    private Double pvp;
    private List<String> imagenes;
}
