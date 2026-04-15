package com.vaultify.user.controller;

import com.vaultify.user.dto.UserRegistrationRequest;
import com.vaultify.user.dto.UserResponse;
import com.vaultify.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // Register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    // Login (email/mobile)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserResponse request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
