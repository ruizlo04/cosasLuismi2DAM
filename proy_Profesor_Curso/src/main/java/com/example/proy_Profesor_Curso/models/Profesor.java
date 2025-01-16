package com.example.proy_Profesor_Curso.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private int puntuacion;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "profesor",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL,
                orphanRemoval = true
    )
    private List<CursoOnline> cursos = new ArrayList<>();

    public void addCursoOnline(CursoOnline curso){
        curso.setProfesor(this);
        this.cursos.add(curso);
    }

    public void deleteCursoOnline(CursoOnline curso){
        this.cursos.remove(curso);
    }
}
