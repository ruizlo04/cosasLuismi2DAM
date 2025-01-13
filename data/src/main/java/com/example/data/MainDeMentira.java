package com.example.data;

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

        repo.save(p);

    }
}
