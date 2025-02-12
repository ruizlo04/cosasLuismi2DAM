package com.example.pruebaJwt_CarlosRuiz.user.controller;

import com.example.pruebaJwt_CarlosRuiz.user.dto.CreateUserCmd;
import com.example.pruebaJwt_CarlosRuiz.user.dto.LoginRequest;
import com.example.pruebaJwt_CarlosRuiz.user.dto.UserResponse;
import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import com.example.pruebaJwt_CarlosRuiz.user.security.jwt.access.JwtService;
import com.example.pruebaJwt_CarlosRuiz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse>register(@RequestBody CreateUserCmd createUserCmd){
        User user = userService.createUser(createUserCmd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user, accessToken));
    }


    @GetMapping("me")
    public UserResponse me (@AuthenticationPrincipal User user){
        return UserResponse.of(user);
    }
}
