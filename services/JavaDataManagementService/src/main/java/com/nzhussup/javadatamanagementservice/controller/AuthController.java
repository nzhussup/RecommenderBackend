package com.nzhussup.javadatamanagementservice.controller;

import com.nzhussup.javadatamanagementservice.entity.UserEntity;
import com.nzhussup.javadatamanagementservice.model.AuthRequest;
import com.nzhussup.javadatamanagementservice.model.AuthResponse;
import com.nzhussup.javadatamanagementservice.model.User;
import com.nzhussup.javadatamanagementservice.security.JWTIssuer;
import com.nzhussup.javadatamanagementservice.service.PasswordUtil;
import com.nzhussup.javadatamanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JWTIssuer jwtIssuer;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Validated AuthRequest request) {

        UserEntity user = userService.authFindByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!PasswordUtil.verifyPassword(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtIssuer.issue(user.getId(), user.getEmail(), List.of(user.getRole()));

        AuthResponse authResponse = AuthResponse.builder().accessToken(token).build();
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Validated AuthRequest request) {

        UserEntity user = userService.registerUser(request);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtIssuer.issue(user.getId(), user.getEmail(), List.of(user.getRole()));
        AuthResponse authResponse = AuthResponse.builder().accessToken(token).build();
        return ResponseEntity.ok(authResponse);
    }

}

