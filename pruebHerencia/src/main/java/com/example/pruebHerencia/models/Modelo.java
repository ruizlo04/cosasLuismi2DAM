package com.example.pruebHerencia.models;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Modelo extends Car{

    private String modelo;

    public Modelo (Long id, String nombre, String modelo){
        super(id, nombre);
        this.modelo = modelo;
    }
}
