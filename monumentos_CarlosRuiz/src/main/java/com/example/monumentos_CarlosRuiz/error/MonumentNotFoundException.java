package com.example.monumentos_CarlosRuiz.error;

public class MonumentNotFoundException extends RuntimeException{

    public MonumentNotFoundException() {
        super("No hay monumentos con esos requisitos de búsqueda");
    }

    public MonumentNotFoundException(Long id){
        super("No hay monumento con ese ID");
    }
    public MonumentNotFoundException(String msg){
        super(msg);
    }


}
