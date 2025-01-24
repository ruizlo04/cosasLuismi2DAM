package com.example.pruebaHerenciaSingleTable.repositories;

import com.example.pruebaHerenciaSingleTable.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
