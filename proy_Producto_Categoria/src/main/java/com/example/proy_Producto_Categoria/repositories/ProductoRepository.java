package com.example.proy_Producto_Categoria.repositories;

import com.example.proy_Producto_Categoria.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
