package com.example.oauth2spring.controller;

import com.example.oauth2spring.entity.User;
import com.example.oauth2spring.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "Welcome to the home page!";
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(@AuthenticationPrincipal OidcUser oidcUser) {
        User user = userService.findByProviderAndProviderSubject(
                oidcUser.getIssuer().toString(),
                oidcUser.getSubject()
        ).orElseThrow(() -> new RuntimeException("User not found"));

        return Map.of(
                "id", user.getId(),
                "name", user.getName(),
                "email", user.getEmail(),
                "provider", user.getProvider(),
                "providerSubject", user.getProviderSubject()
        );
    }


}
