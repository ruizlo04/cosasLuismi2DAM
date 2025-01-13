package com.example.data;

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
    public List<Categoria> listar() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> crear(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.save(categoria));
    }

    @PutMapping("/")
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoria));
    }

    @DeleteMapping("/")
    public ResponseEntity<Categoria> eliminar(@RequestParam Long id) {
        categoriaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
