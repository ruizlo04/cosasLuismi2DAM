package com.example.data.controller;

import com.example.data.models.Categoria;
import com.example.data.service.CategoriaService;
import com.example.data.dto.EditCategoriaCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> create (@RequestBody EditCategoriaCmd categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.save(categoria));
    }

    @PutMapping("/")
    public ResponseEntity<Categoria> update (@RequestBody EditCategoriaCmd categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoria));
    }

    @DeleteMapping("/")
    public ResponseEntity<Categoria> delete (@RequestParam Long id) {
        categoriaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
