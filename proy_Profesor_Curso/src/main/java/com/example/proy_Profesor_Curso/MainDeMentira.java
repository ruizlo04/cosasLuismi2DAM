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

        /*
         * Cuando se guardaba el curso tras haber añadido los dos primeros videos, estos se almacenan correctamente.
         * Sin embargo, al añadir un nuevo video al curso y volver a guardarlo, Hibernate interpretaba
         * que debía añadir el nuevo video varias veces.
         * Esto daba como resultado la creación de dos videos idénticos pero con IDs diferentes en la base de datos.
         * Debido a esto, el ID del último video añadido aparecía como null en el curso en memoria,
         */
        CursoOnline c = CursoOnline.builder()
                .nombre("PepeCurso")
                .puntuacion(7)
                .profesor(p)
                .build();

        c.addVideos(Video.builder()
                .titulo("Cabestro")
                .url("pira pira pira")
                .build());

        c.addVideos(Video.builder()
                .titulo("Iruaaaa")
                .url("piru piru piru")
                .build());

        c.addVideos(Video.builder()
                .titulo("Vídeo creado por luismi")
                .url("piru piru piru")
                .build());

        cursoOnlineRepository.save(c);

        System.out.println(p);
        System.out.println(c);

        System.out.println(c.getListaDeVideos());

        /*
        * lo que ocurre aqui es que borra bien el curso en la base de datos,
        * sin embargo al imprimirlo de nuevo, sigue saliendo debido a que sigue existiendo
        * en memoria, no en la base de datos
        * */

        cursoOnlineRepository.delete(c);

        System.out.println(c);


    }
}
