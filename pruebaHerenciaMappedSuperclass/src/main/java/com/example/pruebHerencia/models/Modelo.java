package com.example.pruebHerencia.models;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@ToString
@Getter
@Setter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Modelo extends Car{

    private String modelo;

    public Modelo (Long id, String nombre, String modelo){
        super(id, nombre);
        this.modelo = modelo;
    }
}
