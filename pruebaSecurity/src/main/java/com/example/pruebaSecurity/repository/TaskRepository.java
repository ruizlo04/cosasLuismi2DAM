package com.example.pruebaSecurity.repository;

import com.example.pruebaSecurity.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
