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
@DiscriminatorValue("moto")
public class Moto extends Vehiculo {

    private int cilindrada;
}