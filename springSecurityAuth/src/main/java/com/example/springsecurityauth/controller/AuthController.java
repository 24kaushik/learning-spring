package com.example.springsecurityauth.controller;

import com.example.springsecurityauth.dto.login.LoginReqDto;
import com.example.springsecurityauth.dto.login.LoginResponseDto;
import com.example.springsecurityauth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginReqDto loginReqDto
    ) {
        Authentication authenticationReq = UsernamePasswordAuthenticationToken.unauthenticated(
                loginReqDto.getUsername(),
                loginReqDto.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationReq);

        String token = jwtService.generateToken(authentication);

        return ResponseEntity.ok(new LoginResponseDto(token));

    }
}
