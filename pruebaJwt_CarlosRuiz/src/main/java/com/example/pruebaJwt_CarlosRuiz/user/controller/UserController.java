package com.example.pruebaJwt_CarlosRuiz.user.controller;

import com.example.pruebaJwt_CarlosRuiz.user.dto.UserResponse;
import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import com.example.pruebaJwt_CarlosRuiz.user.security.jwt.access.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        AuthenticationManager authenticationManager =
                authenticationManagerBuilder.authenticationProvider(authenticationProvider())
                        .build();

        return authenticationManager;
    }

    @GetMapping("/me")
    public UserResponse me (@AuthenticationPrincipal User user){
        return UserResponse.of(user);
    }

    @GetMapping("/me/admin")
    public User adminMe(@AuthenticationPrincipal User user){
        return user;
    }


    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();

        p.setUserDetailsService(userDetailsService);
        p.setPasswordEncoder(passwordEncoder);
        return p;

    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.cors(Customizer.withDefaults());
        http.sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.POST, "/auth/register", "/auth/login").permitAll()
                .anyRequest().authenticated());


        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
