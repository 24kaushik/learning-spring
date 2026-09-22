package com.example.springsecurityauth.service;

import com.example.springsecurityauth.dto.register.UserRegisterRequestDto;
import com.example.springsecurityauth.dto.register.UserRegisterResponseDto;
import com.example.springsecurityauth.entity.Role;
import com.example.springsecurityauth.entity.User;
import com.example.springsecurityauth.repository.RoleRepository;
import com.example.springsecurityauth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        user.setPassword(encodedPassword);

        Role role = roleRepository.findByName("ROLE_USER");

        user.setRoles(Collections.singleton(role));

        userRepository.save(user);
        return new UserRegisterResponseDto(user.getUsername(), "User registered successfully");
    }

}
