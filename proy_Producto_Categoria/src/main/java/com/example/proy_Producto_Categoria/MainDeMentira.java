package com.example.proy_Producto_Categoria;

import com.example.proy_Producto_Categoria.models.Categoria;
import com.example.proy_Producto_Categoria.models.Producto;
import com.example.proy_Producto_Categoria.repositories.CategoriaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

        private CategoriaRepository categoriaRepository;

        @PostConstruct
        public void run() {

            Categoria categoriaPadre = Categoria.builder()
                            .nombre("Electrónica")
                                    .build();


            categoriaRepository.save(categoriaPadre);

            Categoria subcategoria1 = Categoria.builder()
                    .nombre("Móviles")
                    .build();

            categoriaRepository.save(subcategoria1);

            subcategoria1.setCategoriaPadre(categoriaPadre);

            Categoria subcategoria2 = Categoria.builder()
                    .nombre("Portátiles")
                    .build();

            categoriaRepository.save(subcategoria2);

            subcategoria2.setCategoriaPadre(categoriaPadre);

            categoriaPadre.getSubcategorias().add(subcategoria1);
            categoriaPadre.getSubcategorias().add(subcategoria2);



            Producto producto = Producto.builder()
                    .nombre("Iphone")
                    .pvp(100.0)
                    .categoria(subcategoria1)
                    .build();

            System.out.println(producto);
            System.out.println(categoriaPadre);
            System.out.println(subcategoria1);

        }

}
