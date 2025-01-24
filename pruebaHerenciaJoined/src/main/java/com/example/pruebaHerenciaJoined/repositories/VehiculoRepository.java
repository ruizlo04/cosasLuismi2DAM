package com.example.pruebaHerenciaJoined.repositories;

import com.example.pruebaHerenciaJoined.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
