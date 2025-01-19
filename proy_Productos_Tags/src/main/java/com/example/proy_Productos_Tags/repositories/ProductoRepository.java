package com.example.proy_Productos_Tags.repositories;

import com.example.proy_Productos_Tags.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
