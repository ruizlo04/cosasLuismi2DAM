package com.example.pruebaHerenciaSingleTable.models;

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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Vehiculo {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

}
