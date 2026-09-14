package com.example.springsecurityauth.service;

import com.example.springsecurityauth.dto.UserRegisterRequestDto;
import com.example.springsecurityauth.dto.UserRegisterResponseDto;
import com.example.springsecurityauth.entity.User;
import com.example.springsecurityauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        return new UserRegisterResponseDto(user.getUsername(), "User registered successfully");
    }

}
