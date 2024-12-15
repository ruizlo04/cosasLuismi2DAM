package com.example.proyectoDtoAlumnoProductoCarlosRuiz;

import com.example.proyectoDtoAlumnoProductoCarlosRuiz.alumno.Alumno;
import com.example.proyectoDtoAlumnoProductoCarlosRuiz.alumno.AlumnoDto;
import com.example.proyectoDtoAlumnoProductoCarlosRuiz.alumno.Curso;
import com.example.proyectoDtoAlumnoProductoCarlosRuiz.alumno.Direccion;
import com.example.proyectoDtoAlumnoProductoCarlosRuiz.producto.Categoria;
import com.example.proyectoDtoAlumnoProductoCarlosRuiz.producto.Producto;
import com.example.proyectoDtoAlumnoProductoCarlosRuiz.producto.ProductoDto;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Run {

    @PostConstruct
    public static void main(String[] args) {
        Categoria categoria = new Categoria(1L, "Hogar y Cocina");
        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Robot Aspirador")
                .pvp(299.99)
                .imagenes(Arrays.asList("robot1.png", "robot2.png"))
                .categoria(categoria)
                .build();

        ProductoDto productoDTO = ProductoDto.ofProducto(producto);

        Direccion direccion = Direccion.builder()
                .id(1L)
                .tipoVia("Avenida")
                .linea1("456 Oak Street")
                .linea2("Piso 2, Puerta C")
                .cp("67890")
                .poblacion("Villa Verde")
                .provincia("Andalucía")
                .build();

        Curso curso = Curso.builder()
                .id(1L)
                .nombre("Historia del Arte")
                .tipo("Humanidades")
                .tutor("Prof. Martínez")
                .aula("Aula 205")
                .build();

        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("Lucía")
                .apellido1("Fernández")
                .apellido2("Martín")
                .gmail("lucia.fernandez@example.com")
                .curso(curso)
                .direccion(direccion)
                .build();

        AlumnoDto alumnoDTO = AlumnoDto.ofAlumno(alumno);

        System.out.println(productoDTO);
        System.out.println(alumnoDTO);
    }
}
