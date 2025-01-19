package com.example.proy_Productos_Tags.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Tags {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "listaTags", fetch = FetchType.EAGER)
    @Builder.Default
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    private List<Producto> listaProductos = new ArrayList<>();

}
