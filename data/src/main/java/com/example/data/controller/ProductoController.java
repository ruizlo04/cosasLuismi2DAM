package com.example.data.controller;

import com.example.data.dto.EditProductoCmd;
import com.example.data.models.Producto;
import com.example.data.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/productos")
@RestController
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/")
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Producto> create(@RequestBody EditProductoCmd producto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoService.save(producto));
    }

    @PutMapping("/")
    public ResponseEntity<Producto> update(@RequestBody EditProductoCmd producto) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> delete(@RequestParam Long id) {
        productoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
