package com.example.proy_Profesor_Curso.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private int puntuacion;

    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoOnline",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    @ToString.Exclude
    private List<Video> listaDeVideos = new ArrayList<>();

    public void addVideos(Video v){
        v.setCursoOnline(this);
        this.listaDeVideos.add(v);
    }

    public void deleteVideos(Video v){
        this.listaDeVideos.remove(v);
    }

}
