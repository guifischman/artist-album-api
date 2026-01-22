package com.company.artist_album_api.auth.service;

import com.company.artist_album_api.auth.dto.AuthRequest;
import com.company.artist_album_api.auth.dto.AuthResponse;
import com.company.artist_album_api.auth.dto.RefreshTokenRequest;
import com.company.artist_album_api.config.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public AuthResponse authenticate(AuthRequest request) {

        // Exemplo simples (em produção: UserDetailsService + senha criptografada)
        if (!"admin".equals(request.getUsername()) || !"admin".equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String accessToken = jwtTokenProvider.generateToken(request.getUsername(), 5);
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getUsername());

        return new AuthResponse(accessToken, refreshToken, 300);
    }

    public AuthResponse refreshToken(RefreshTokenRequest request) {

        String username = jwtTokenProvider.getUsernameFromToken(request.getRefreshToken());

        String newAccessToken = jwtTokenProvider.generateToken(username, 5);

        return new AuthResponse(newAccessToken, request.getRefreshToken(), 300);
    }
}