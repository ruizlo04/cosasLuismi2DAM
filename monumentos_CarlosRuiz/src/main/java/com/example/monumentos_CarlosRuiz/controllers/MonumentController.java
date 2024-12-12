package com.example.monumentos_CarlosRuiz.controllers;

import com.example.monumentos_CarlosRuiz.repositories.MonumentRepository;
import com.example.monumentos_CarlosRuiz.models.Monument;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentRepository monumentRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Monument>> getAll() {
        List<Monument> result = monumentRepository.getAll();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<Monument> create(@RequestBody Monument monument){
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentRepository.add(monument));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monument> getById(@PathVariable Long id){
        return ResponseEntity.of(
                monumentRepository.get(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monument> editNameById(@PathVariable Long id, @RequestBody Monument m){
        return ResponseEntity.of(monumentRepository.edit(id, m));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Monument> deleteById(@PathVariable Long id){
        monumentRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listOrdenada")
    public ResponseEntity<List<Monument>> getAll(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection){
        List<Monument> result = monumentRepository.query(max, sortDirection);

        if(result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }


}