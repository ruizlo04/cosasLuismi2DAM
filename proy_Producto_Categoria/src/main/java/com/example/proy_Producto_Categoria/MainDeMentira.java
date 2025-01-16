package com.example.proy_Producto_Categoria;

import com.example.proy_Producto_Categoria.models.Categoria;
import com.example.proy_Producto_Categoria.models.Producto;
import com.example.proy_Producto_Categoria.repositories.CategoriaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MainDeMentira {

        @Autowired
        private CategoriaRepository categoriaRepository;

        @PostConstruct
        public void run(String... args) {

            Categoria categoriaPadre = Categoria.builder()
                    .nombre("Electrónica")
                    .build();

            Categoria subcategoria = Categoria.builder()
                    .nombre("Teléfonos")
                    .build();

            categoriaPadre.setSubcategorias(List.of(subcategoria));

            categoriaRepository.save(categoriaPadre);
            categoriaRepository.save(subcategoria);

            Producto producto = Producto.builder()
                    .nombre("Iphone")
                    .pvp(100.0)
                    .categoria(subcategoria)
                    .build();

            subcategoria.setProductos(List.of(producto));

            subcategoria.addProducto(producto);

        }

}
