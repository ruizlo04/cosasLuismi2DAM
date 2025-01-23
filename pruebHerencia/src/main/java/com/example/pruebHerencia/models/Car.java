package com.example.pruebHerencia.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id @GeneratedValue
    protected Long id;

    protected String nombre;
}
