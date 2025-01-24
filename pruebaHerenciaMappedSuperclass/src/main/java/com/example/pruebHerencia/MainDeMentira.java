package com.example.pruebHerencia;

import com.example.pruebHerencia.models.Modelo;
import com.example.pruebHerencia.repositories.ModeloRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ModeloRepository modeloRepository;

    @PostConstruct
    public void run(){

        Modelo car1 = Modelo.builder()
                .nombre("Opel")
                .modelo("Corsa")
                .build();

        Modelo car2 = Modelo.builder()
                .nombre("Toyota")
                .modelo("Corolla")
                .build();

        modeloRepository.save(car1);

        System.out.println(car1);
    }
}
