package com.example.pruebaJwt_CarlosRuiz.user.security.jwt.refresh;

import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.refresh.duration}")
    private int durationMinutes;

    @Transactional
    public RefreshToken create(User user){
        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .user(user)
                        .token(UUID.randomUUID().toString())
                        .expiredAt(Instant.now().plusSeconds(durationMinutes))
                        .build()
        );
    }
}
