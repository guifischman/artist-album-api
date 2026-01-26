package com.company.artist_album_api.auth;

import com.company.artist_album_api.auth.dto.AuthRequest;
import com.company.artist_album_api.auth.dto.AuthResponse;
import com.company.artist_album_api.auth.dto.RefreshTokenRequest;
import com.company.artist_album_api.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        AuthResponse response =
                authService.authenticate(request.username(), request.password());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshTokenRequest request) {

        AuthResponse response =
                authService.refreshToken(request.refreshToken());

        return ResponseEntity.ok(response);
    }
}
