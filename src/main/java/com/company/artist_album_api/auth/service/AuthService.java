package com.company.artist_album_api.auth.service;


import com.company.artist_album_api.auth.dto.AuthRequest;
import com.company.artist_album_api.auth.dto.AuthResponse;
import com.company.artist_album_api.auth.dto.RefreshTokenRequest;
import com.company.artist_album_api.security.jwt.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;

    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public AuthResponse authenticate(AuthRequest request) {

        // Simples, proposital (edital não exige banco de usuários)
        if (!"admin".equals(request.username()) || !"admin".equals(request.password())) {
            throw new RuntimeException("Invalid credentials");
        }

        String accessToken = jwtService.generateAccessToken(request.username());
        String refreshToken = jwtService.generateRefreshToken(request.username());

        return new AuthResponse(
                accessToken,
                refreshToken,
                jwtService.getAccessTokenExpirationSeconds()
        );
    }

    public AuthResponse refreshToken(RefreshTokenRequest request) {

        String refreshToken = request.refreshToken();

        if (!jwtService.isTokenValid(refreshToken)) {
            throw new RuntimeException("Invalid or expired refresh token");
        }

        String subject = jwtService.extractSubject(refreshToken);

        String newAccessToken = jwtService.generateAccessToken(subject);
        String newRefreshToken = jwtService.generateRefreshToken(subject);

        return new AuthResponse(
                newAccessToken,
                newRefreshToken,
                jwtService.getAccessTokenExpirationSeconds()
        );
    }
}