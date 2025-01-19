package com.example.proy_Productos_Tags.service;

import com.example.proy_Productos_Tags.dto.EditProductoCmd;
import com.example.proy_Productos_Tags.models.Producto;
import com.example.proy_Productos_Tags.repositories.CategoriaRepository;
import com.example.proy_Productos_Tags.repositories.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Producto> findAll() {
        /*
            Obtener todos los productos
            Si la lista está vacía
                Lanzo excepción
         */
        List<Producto> result = productoRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay productos con esos criterios de búsqueda");
        return result;
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));
    }

    public Producto save(EditProductoCmd nuevo) {
        return productoRepository.save(Producto.builder()
                .nombre(nuevo.nombre())
                .precio(nuevo.precio())
                //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
                .categoria(categoriaRepository.findById(nuevo.categoriaId()).orElse(null))
                .descripcion(nuevo.descripcion())
                .build());
    }

    public Producto edit(EditProductoCmd editProductoCmd, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(editProductoCmd.nombre());
                    old.setDescripcion(editProductoCmd.descripcion());
                    old.setPrecio(editProductoCmd.precio());
                    //old.setCategoria(categoriaRepository.getReferenceById(editProductoCmd.categoriaId()));
                    old.setCategoria(categoriaRepository.findById(editProductoCmd.categoriaId()).orElse(null));
                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));

    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
