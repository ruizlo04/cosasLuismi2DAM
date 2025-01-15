package com.example.data.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
@Table(name = "cursos")
public class Curso {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Estudiante> estudianteList = new ArrayList<>();


        public void addEstudiante(Estudiante e){
        e.setCurso(this);
        this.getEstudianteList().add(e);
    }

    public void remove(Estudiante e){
        this.getEstudianteList().remove(e);
        e.setCurso(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Curso curso = (Curso) o;
        return getId() != null && Objects.equals(getId(), curso.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
