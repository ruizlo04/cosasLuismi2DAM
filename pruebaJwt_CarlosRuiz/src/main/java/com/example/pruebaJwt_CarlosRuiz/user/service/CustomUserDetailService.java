package com.example.pruebaJwt_CarlosRuiz.user.service;

import com.example.pruebaJwt_CarlosRuiz.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userdetailService")
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usewrname not found"));
    }
}
