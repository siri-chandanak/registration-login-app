package com.example.authapp.controller;

import com.example.authapp.dto.LoginRequest;
import com.example.authapp.dto.RegisterRequest;
import com.example.authapp.model.User;
import com.example.authapp.service.AuthService;
import com.example.authapp.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(
            AuthService authService,
            JwtService jwtService
    ) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody RegisterRequest request
    ) {

        User user = authService.register(request);

        Map<String, Object> response = new HashMap<>();

        response.put("message", "User registered successfully");
        response.put("userId", user.getId());
        response.put("email", user.getEmail());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request
    ) {

        User user = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        String token = jwtService.generateToken(
                user.getEmail()
        );

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Login successful");
        response.put("token", token);
        response.put("userId", user.getId());
        response.put("email", user.getEmail());
        response.put("firstName", user.getFirstName());

        return ResponseEntity.ok(response);
    }
}