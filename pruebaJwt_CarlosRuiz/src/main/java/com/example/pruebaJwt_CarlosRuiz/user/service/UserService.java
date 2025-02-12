package com.example.pruebaJwt_CarlosRuiz.user.service;


import com.example.pruebaJwt_CarlosRuiz.user.dto.CreateUserCmd;
import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import com.example.pruebaJwt_CarlosRuiz.user.model.UserRole;
import com.example.pruebaJwt_CarlosRuiz.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserCmd createUserCmd){
        User user = User.builder()
                .username(createUserCmd.username())
                .password(passwordEncoder.encode(createUserCmd.password()))
                .roles(Set.of(UserRole.USER))
                .build();

        return userRepository.save(user);
    }
}
