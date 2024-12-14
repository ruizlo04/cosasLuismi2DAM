package com.example.proyectoDtoAlumnoProductoCarlosRuiz.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {
    private Long id;
    private String nombre;
}
