package com.example.authapp.controller;

import com.example.authapp.dto.RegisterRequest;
import com.example.authapp.model.User;
import com.example.authapp.service.AuthService;
import com.example.authapp.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
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

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Login successful");
        response.put("userId", user.getId());
        response.put("email", user.getEmail());
        response.put("firstName", user.getFirstName());

        return ResponseEntity.ok(response);
    }
}