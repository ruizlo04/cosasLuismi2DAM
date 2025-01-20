package com.example.proy_Profesor_Curso;

import com.example.proy_Profesor_Curso.models.CursoOnline;
import com.example.proy_Profesor_Curso.models.Profesor;
import com.example.proy_Profesor_Curso.models.Video;
import com.example.proy_Profesor_Curso.repositories.CursoOnlineRepository;
import com.example.proy_Profesor_Curso.repositories.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProfesorRepository profesorRepository;

    private final CursoOnlineRepository cursoOnlineRepository;

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

        //cursoOnlineRepository.save(c);

        Video v = Video.builder()
                .titulo("Cabestro")
                .url("pira pira pira")
                //.cursoOnline(c)
                .build();

        Video v1 = Video.builder()
                .titulo("Iruaaaa")
                .url("piru piru piru")
                //.cursoOnline(c)
                .build();

        c.addVideos(v);
        c.addVideos(v1);

        cursoOnlineRepository.save(c);

        Video v2 = Video.builder()
                .titulo("Vídeo creado por luismi")
                .url("piru piru piru")
                //.cursoOnline(c)
                .build();


        c.addVideos(v2);

        cursoOnlineRepository.save(c);

        //p.addCursoOnline(c);

        System.out.println(p);
        System.out.println(c);
        System.out.println(v);
        System.out.println(v1);
        System.out.println(v2);

        System.out.println(c.getListaDeVideos());


        /*c.deleteVideos(v1);

        cursoOnlineRepository.save(c);*/

        cursoOnlineRepository.delete(c);

        /*System.out.println(c);

        System.out.println("\n\n");
        cursoOnlineRepository.findAll()
                .forEach(curso -> {
                    System.out.println(curso.toString());
                    curso.getListaDeVideos()
                            .forEach(System.out::println);
                    System.out.println("");
                });*/

    }
}
