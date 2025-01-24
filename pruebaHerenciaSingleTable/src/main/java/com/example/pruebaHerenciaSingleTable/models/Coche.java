package com.example.pruebaHerenciaSingleTable.models;

import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue("coche")
public class Coche extends Vehiculo {

    private int numRuedas;
}