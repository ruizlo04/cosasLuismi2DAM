package com.example.pruebaHerenciaJoined;

import com.example.pruebaHerenciaJoined.models.Coche;
import com.example.pruebaHerenciaJoined.models.Moto;
import com.example.pruebaHerenciaJoined.repositories.VehiculoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final VehiculoRepository vehiculoRepository;

    @PostConstruct
    public void run(){

        Coche car1 = Coche.builder()
                .nombre("Opel")
                .numRuedas(4)
                .build();

        Moto moto1 = Moto.builder()
                .nombre("Harley")
                .color("Rojo")
                .build();

        vehiculoRepository.save(car1);
        vehiculoRepository.save(moto1);

        System.out.println(car1);
        System.out.println(moto1);
    }
}
