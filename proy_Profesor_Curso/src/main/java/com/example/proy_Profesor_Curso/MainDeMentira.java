package com.example.proy_Profesor_Curso;

import com.example.proy_Profesor_Curso.models.CursoOnline;
import com.example.proy_Profesor_Curso.models.Profesor;
import com.example.proy_Profesor_Curso.models.Video;
import com.example.proy_Profesor_Curso.repositories.CursoOnlineRepository;
import com.example.proy_Profesor_Curso.repositories.ProfesorRepository;
import com.example.proy_Profesor_Curso.repositories.VideoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProfesorRepository profesorRepository;

    private final CursoOnlineRepository cursoOnlineRepository;

    private final VideoRepository videoRepository;

    @PostConstruct
    public void run(){

        Profesor p = Profesor.builder()
                .nombre("Manolo")
                .email("a@a")
                .puntuacion(9)
                .build();

        profesorRepository.save(p);

        CursoOnline c = CursoOnline.builder()
                .nombre("PepeCurso")
                .puntuacion(7)
                .profesor(p)
                .build();

        cursoOnlineRepository.save(c);

        p.addCursoOnline(c);

        Video v = Video.builder()
                .titulo("Cabestro")
                .url("piru piru piru")
                .cursoOnlineId(c.getId())
                .cursoOnline(c)
                .build();

        Video v1 = Video.builder()
                .titulo("Iruaaaa")
                .url("piru piru piru")
                .cursoOnlineId(c.getId())
                .cursoOnline(c)
                .build();

        videoRepository.save(v);
        videoRepository.save(v1);


        c.addVideos(v);
    }
}
