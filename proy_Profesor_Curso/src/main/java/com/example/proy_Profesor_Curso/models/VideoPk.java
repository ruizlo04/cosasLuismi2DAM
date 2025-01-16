package com.example.proy_Profesor_Curso.models;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoPk implements Serializable {
    private Long id;
    private Long cursoOnlineId;
}

