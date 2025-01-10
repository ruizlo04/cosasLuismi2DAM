package com.example.monumentos_CarlosRuiz.controllers;

import com.example.monumentos_CarlosRuiz.error.MonumentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonumentNotFoundException.class)
    public ProblemDetail handleMonumentNotFound(MonumentNotFoundException ex){
        ProblemDetail result = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                    ex.getMessage());
        result.setTitle("Monumento no encontrado");
        result.setType(URI.create(""));

        return result;
    }
}
