package com.example.proy_Productos_Tags.repositories;

import com.example.proy_Productos_Tags.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
