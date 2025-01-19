package com.example.proy_Productos_Tags.repositories;

import com.example.proy_Productos_Tags.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tags, Long> {
}
