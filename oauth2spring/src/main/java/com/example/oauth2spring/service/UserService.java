package com.example.oauth2spring.service;

import com.example.oauth2spring.entity.User;
import com.example.oauth2spring.repository.UserRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerOrUpdate(String provider, OidcUser oidcUser) {
        String providerSubject = oidcUser.getSubject();
        String name = oidcUser.getClaimAsString("name");
        String email = oidcUser.getClaimAsString("email");

        Optional<User> optionalUser = userRepository.findByProviderAndProviderSubject(provider, providerSubject);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update existing user properties from oidcUser if needed
            existingUser.setName(name);
            existingUser.setEmail(email);
            return existingUser;
        }

        User newUser = new User(name, email, provider, providerSubject);
        return userRepository.save(newUser);

    }

    public Optional<User> findByProviderAndProviderSubject(String provider, String providerSubject) {
        return userRepository.findByProviderAndProviderSubject(provider, providerSubject);
    }
}
