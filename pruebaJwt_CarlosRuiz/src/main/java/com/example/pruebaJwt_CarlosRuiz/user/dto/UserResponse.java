package com.example.pruebaJwt_CarlosRuiz.user.dto;

import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String refreshToken
) {

    public static UserResponse of (User user){
        return new UserResponse(user.getId(), user.getUsername(), null);
    }

    public static UserResponse of (User user, String token) {
        return new UserResponse(user.getId(), user.getUsername(), token);
    }


}
