package com.example.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductRepository repo;

    @PostConstruct
    public void run(){
     Producto p = Producto.builder()
             .nombre("A")
             .descripcion("AS")
             .precio(12)
             .build();

     repo.save(p);

    }
}
