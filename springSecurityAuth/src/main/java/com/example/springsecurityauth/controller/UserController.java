package com.example.springsecurityauth.controller;

import com.example.springsecurityauth.dto.UserRegisterRequestDto;
import com.example.springsecurityauth.dto.UserRegisterResponseDto;
import com.example.springsecurityauth.service.AuthService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<String> getUser(Authentication authentication) {
        return ResponseEntity.ok("User endpoint" + authentication.getName());
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> registerUser(@RequestBody UserRegisterRequestDto requestDto) {
        UserRegisterResponseDto responseDto = authService.register(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(CsrfToken token) {
        return token;
    }
}
