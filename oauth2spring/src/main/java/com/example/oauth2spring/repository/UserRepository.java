package com.example.oauth2spring.repository;

import com.example.oauth2spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProviderAndProviderSubject(String provider, String providerSubject);
}
