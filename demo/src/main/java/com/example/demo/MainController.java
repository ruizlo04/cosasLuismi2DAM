package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class MainController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/producto/123")
    public Product getProducto(){
        return new Product(123L, "Un producto molón");
    }

    @PostMapping("/producto")
    public Product nuevoProducto(@RequestBody Product producto){
        return producto;
    }

    record Product(Long id, String nombre){}



}
