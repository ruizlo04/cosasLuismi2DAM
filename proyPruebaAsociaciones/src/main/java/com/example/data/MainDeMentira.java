package com.example.data;

import com.example.data.models.Curso;
import com.example.data.models.Estudiante;
import com.example.data.repos.CursoRepository;
import com.example.data.repos.EstudianteRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final EstudianteRepository estudianteRepo;

    private final CursoRepository cursoRepository;

    @PostConstruct
    public void run(){

        Curso c = Curso.builder()
                .nombre("1ºDAM")
                .build();

        cursoRepository.save(c);

        Estudiante e = Estudiante.builder()
                .nombre("Antonio")
                .curso(c)
                .build();

        Estudiante e2 = Estudiante.builder()
                .nombre("Manolo")
                .curso(c)
                .build();

        estudianteRepo.save(e);
        estudianteRepo.save(e2);
    }
}
