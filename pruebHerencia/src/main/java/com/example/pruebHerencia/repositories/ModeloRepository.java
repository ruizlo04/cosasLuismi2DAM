package com.example.pruebHerencia.repositories;

import com.example.pruebHerencia.models.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
