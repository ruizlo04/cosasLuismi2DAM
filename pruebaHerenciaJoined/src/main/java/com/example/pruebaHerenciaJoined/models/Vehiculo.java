package com.example.pruebaHerenciaJoined.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@ToString
@Getter
@Setter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo {

    @Id
    @GeneratedValue
    protected Long id;

    protected String nombre;
}
