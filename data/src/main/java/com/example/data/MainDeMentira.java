package com.example.data;

import com.example.data.models.Categoria;
import com.example.data.models.Producto;
import com.example.data.repos.CategoriaRepository;
import com.example.data.repos.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductRepository repo;

    private final CategoriaRepository categoriaRepo;

    @PostConstruct
    public void run(){

        Categoria c = Categoria.builder()
                .nombre("Mi prima la coja")
                .build();

        categoriaRepo.save(c);

        Producto p = Producto.builder()
                 .nombre("A")
                 .descripcion("AS")
                 .precio(12)
                 .categoria(c)
                 .build();

        c.addProducto(p);

        repo.save(p);

        System.out.println("Productos de la categoria esa");
        System.out.println(c.getProductos());

    }
}
