package com.example.proy_Profesor_Curso.models;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoPk {
    private Long id;
    private CursoOnline cursoOnline;
}

