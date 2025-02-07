package com.example.pruebaSecurity.service;

import com.example.pruebaSecurity.model.Task;
import com.example.pruebaSecurity.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Task create (Task t){
        return taskRepository.save(t);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
