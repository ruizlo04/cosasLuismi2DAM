package com.example.proy_Producto_Categoria.repositories;

import com.example.proy_Producto_Categoria.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
