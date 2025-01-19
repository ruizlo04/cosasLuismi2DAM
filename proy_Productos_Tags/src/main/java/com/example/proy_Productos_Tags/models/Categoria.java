package com.example.proy_Productos_Tags.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Categoria {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "categoria",
                fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Producto> listaProductos = new ArrayList<>();

    public void addProducto(Producto p){
        p.setCategoria(this);
        this.listaProductos.add(p);
    }

    public void removeProducto(Producto p){
        this.listaProductos.remove(p);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
