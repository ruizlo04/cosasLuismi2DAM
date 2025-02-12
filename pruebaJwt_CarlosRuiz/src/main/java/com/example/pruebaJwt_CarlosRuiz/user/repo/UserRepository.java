package com.example.pruebaJwt_CarlosRuiz.user.repo;

import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findFirstByUsername(String username);


}
