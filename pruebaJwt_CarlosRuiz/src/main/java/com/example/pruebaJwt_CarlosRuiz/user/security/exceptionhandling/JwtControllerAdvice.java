package com.example.pruebaJwt_CarlosRuiz.user.security.exceptionhandling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class JwtControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ProblemDetail handleAuthenticationException (AuthenticationException ex, HttpServletRequest request){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, ex.getMessage());
        //Añadir un header WWW-Authenticate.Bearer

        return problemDetail;
    }
}
