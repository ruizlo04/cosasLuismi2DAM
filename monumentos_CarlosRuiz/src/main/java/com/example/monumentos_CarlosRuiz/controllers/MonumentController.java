package com.example.monumentos_CarlosRuiz.controllers;

import com.example.monumentos_CarlosRuiz.models.Monument;
import com.example.monumentos_CarlosRuiz.services.MonumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Monumento", description = "El controlador de monumentos")
@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentService monumentService;

    @Operation(summary = "Crea un nuevo monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Monumento creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<Monument> create(@RequestBody Monument monument) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentService.add(monument));
    }

    @Operation(summary = "Obtiene un monumento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Monumento encontrado"),
            @ApiResponse(responseCode = "404", description = "Monumento no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Monument> getById(@PathVariable Long id) {
        return ResponseEntity.ok(monumentService.get(id));
    }

    @Operation(summary = "Edita un monumento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Monumento editado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Monumento no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Monument> edit(@PathVariable Long id, @RequestBody Monument monument) {
        return ResponseEntity.ok(monumentService.edit(id, monument));
    }

    @Operation(summary = "Elimina un monumento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Monumento eliminado"),
            @ApiResponse(responseCode = "404", description = "Monumento no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        monumentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtiene una lista ordenada de monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de monumentos"),
            @ApiResponse(responseCode = "404", description = "No se encontraron monumentos")
    })
    @GetMapping("/listOrdenada")
    public ResponseEntity<List<Monument>> getAll(
            @RequestParam(required = false, defaultValue = "-1") double maxLatitude,
            @RequestParam(required = false, defaultValue = "no") String sortDirection) {
        return ResponseEntity.ok(monumentService.query(maxLatitude, sortDirection));
    }
}
