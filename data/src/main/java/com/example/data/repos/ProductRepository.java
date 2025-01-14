package com.example.data.repos;

import com.example.data.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Producto, Long> {
}
