package com.example.proy_Profesor_Curso.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@IdClass(VideoPk.class)
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    @Id
    private Long cursoOnlineId;

    private int orden;

    private String titulo;

    private String descripcion;

    private String url;

    @ManyToOne
    @JoinColumn(name = "cursoOnlineId", insertable = false, updatable = false)
    private CursoOnline cursoOnline;

}
