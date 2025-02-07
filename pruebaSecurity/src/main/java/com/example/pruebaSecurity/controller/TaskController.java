package com.example.pruebaSecurity.controller;

import com.example.pruebaSecurity.model.Task;
import com.example.pruebaSecurity.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public List<Task>getAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskService.findById(id).get();
    }

    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task t){
        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
