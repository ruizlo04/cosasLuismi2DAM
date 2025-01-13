package com.example.data;

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
            throw new EntityNotFoundException("Categoria nao encontrada");
        }
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria nao encontrada"));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Categoria update(Categoria categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la categoria"));
    }


    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
