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

        Modelo car1 = new Modelo(null, "Ford", "Focus");
        Modelo car2 = new Modelo(null, "Toyota", "Corolla");

        modeloRepository.save(car1);

        System.out.println(car1);
    }
}
