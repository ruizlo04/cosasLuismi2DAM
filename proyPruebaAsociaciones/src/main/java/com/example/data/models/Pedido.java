package com.example.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private LocalDateTime fecha = LocalDateTime.now();

    private String cliente;

    @OneToMany(mappedBy = "pedido",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL,
                orphanRemoval = true
                )
    @Builder.Default
    @ToString.Exclude
    @Setter()
    private List<LineaDePedido> lineaDePedidos = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pedido pedido = (Pedido) o;
        return getId() != null && Objects.equals(getId(), pedido.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
