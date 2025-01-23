package com.example.pruebHerencia.repositories;

import com.example.pruebHerencia.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
