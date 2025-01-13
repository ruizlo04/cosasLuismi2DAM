package com.example.data;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductRepository productRepository;

    private final CategoriaRepository categoriaRepository;

    public List<Producto> findAll() {
        /*
         * Obtener todos los productos
         * y si la lista esta vacia lanzar
         * una excepcion
         * */
        List<Producto> productos = productRepository.findAll();
        if (productos.isEmpty()) {
            throw new EntityNotFoundException("No se encontro el producto");
        }
        return productos;
    }

    public Producto findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el producto"));
    }

    public Producto save(EditProductoCmd producto) {
        return productRepository.save(Producto.builder()
                        .nombre(producto.nombre())
                        .precio(producto.precio())
                        .categoria(categoriaRepository.findById(producto.categoriaId()).orElseThrow())
                        .descripcion(producto.descripcion())
                .build());
    }

    public Producto update(EditProductoCmd producto, Long id) {
        return productRepository.findById(id)
                .map(old -> {
                    old.setNombre(producto.nombre());
                    old.setDescripcion(producto.descripcion());
                    old.setPrecio(producto.precio());
                    old.setCategoria(categoriaRepository.findById(producto.categoriaId()).orElseThrow());
                    return productRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el producto"));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}