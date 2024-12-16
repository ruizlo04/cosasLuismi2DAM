package com.example.monumentos_CarlosRuiz.controllers;

import com.example.monumentos_CarlosRuiz.models.Monument;
import com.example.monumentos_CarlosRuiz.services.MonumentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
@Tag(name = "Monumento", description = "El controlador de monumentos")
public class MonumentController {

    private final MonumentService monumentService;

    @PostMapping
    public ResponseEntity<Monument> create(@RequestBody Monument monument){
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentService.add(monument));
    }

    @GetMapping("/{id}")
    public Monument getById(@PathVariable Long id){
        return monumentService.get(id);
    }

    @PutMapping("/{id}")
    public Monument editNameById(@PathVariable Long id, @RequestBody Monument m){
        return monumentService.edit(id,m);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        monumentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listOrdenada")
    public List<Monument> getAll(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ){
        return monumentService.query(max, sortDirection);
    }


}