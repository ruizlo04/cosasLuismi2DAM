package com.example.proy_Productos_Tags.service;

import com.example.proy_Productos_Tags.models.Categoria;
import com.example.proy_Productos_Tags.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty()){
            throw new EntityNotFoundException("no se han encontardo");
        }
        return result;
    }

    public Optional<Categoria> findById(Long id){
        Optional<Categoria> result = categoriaRepository.findById(id);
        if (result.isEmpty()){
            throw new EntityNotFoundException("no se han encontrado");
        }
        return result;
    }

    public Categoria save(Categoria c){
        return categoriaRepository.save(c);
    }

    public Categoria edit(Categoria categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: "+ id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
