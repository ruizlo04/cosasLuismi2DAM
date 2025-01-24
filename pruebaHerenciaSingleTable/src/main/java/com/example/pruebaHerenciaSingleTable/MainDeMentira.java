package com.example.pruebaHerenciaSingleTable;

import com.example.pruebaHerenciaSingleTable.models.Moto;
import com.example.pruebaHerenciaSingleTable.models.Coche;
import com.example.pruebaHerenciaSingleTable.repositories.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final VehiculoRepository vehiculoRepository;

    public void run(){

        Coche coche1 = Coche.builder()
                .nombre("Opel")
                .numRuedas(4)
                .build();


        Coche coche2 = Coche.builder()
                .nombre("Lexus")
                .numRuedas(4)
                .build();


        Moto moto1 = Moto.builder()
                .nombre("Moto 1")
                .cilindrada(120)
                .build();


        Moto moto2 = Moto.builder()
                .nombre("Moto 2")
                .cilindrada(120)
                .build();

        vehiculoRepository.save(coche1);
        vehiculoRepository.save(coche2);
        vehiculoRepository.save(moto1);
        vehiculoRepository.save(moto2);

        System.out.println(vehiculoRepository.findAll());
    }
}
