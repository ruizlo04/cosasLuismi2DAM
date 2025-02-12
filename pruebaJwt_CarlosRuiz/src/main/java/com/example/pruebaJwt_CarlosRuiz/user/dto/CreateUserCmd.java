package com.example.pruebaJwt_CarlosRuiz.user.dto;

public record CreateUserCmd(
        String username, String password, String verifyPassword
) {
}
