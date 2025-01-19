package com.example.proy_Productos_Tags.controller;

import com.example.proy_Productos_Tags.models.Categoria;
import com.example.proy_Productos_Tags.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria nueva) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        categoriaService.save(nueva));
    }

    @PutMapping("/{id}")
    public Categoria edit(@RequestBody Categoria aEditar,
                          @PathVariable Long id) {
        return categoriaService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
