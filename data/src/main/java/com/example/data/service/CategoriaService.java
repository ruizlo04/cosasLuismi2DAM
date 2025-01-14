package com.example.data.service;

import com.example.data.dto.EditCategoriaCmd;
import com.example.data.models.Categoria;
import com.example.data.repos.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty()) {
            throw new EntityNotFoundException("Categoria no encontrada");
        }
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria nao encontrada"));
    }

    public Categoria save(EditCategoriaCmd categoria) {
        return categoriaRepository.save(Categoria.builder()
                .nombre(categoria.nombre()).build());
    }

    public Categoria edit(EditCategoriaCmd editCategoriaCmd, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(editCategoriaCmd.nombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
