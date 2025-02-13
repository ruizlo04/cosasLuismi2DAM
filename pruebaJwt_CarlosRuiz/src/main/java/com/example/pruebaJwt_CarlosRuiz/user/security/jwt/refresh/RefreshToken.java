package com.example.pruebaJwt_CarlosRuiz.user.security.jwt.refresh;

import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshToken {

    @Id
    private UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", columnDefinition = "uuid")
    private User user;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiredAt;

    @Builder.Default
    private Instant createdAt = Instant.now();

}
