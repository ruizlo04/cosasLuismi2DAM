package com.example.proy_Productos_Tags.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Producto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id",
                foreignKey = @ForeignKey(name = "fk_producto_categoria")
    )
    private Categoria categoria;

    @ManyToMany
    @JoinTable(name = "producto_tag",
            joinColumns = @JoinColumn(name="producto_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id"),
            foreignKey = @ForeignKey(name = "fk_producto_tag_producto"),
            inverseForeignKey = @ForeignKey(name = "fk_producto_tag_tag")
    )
    private List<Tags> listaTags = new ArrayList<>();

    public void addTag(Tags t) {
        this.listaTags.add(t);
        t.getListaProductos().add(this);
    }

    public void removeTag(Tags t) {
        this.listaTags.remove(t);
        t.getListaProductos().remove(this);
    }
}
