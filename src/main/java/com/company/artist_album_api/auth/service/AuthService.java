package com.company.artist_album_api.auth.service;

import com.company.artist_album_api.auth.dto.AuthResponse;
import com.company.artist_album_api.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UserDetailsService userDetailsService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public AuthResponse authenticate(String username, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails user = userDetailsService.loadUserByUsername(username);

        String token = jwtService.generateToken(user);

        // Enquanto não houver refresh token real, reutilizamos o mesmo JWT
        return new AuthResponse(
                token,
                token,
                0L
        );
    }

    public AuthResponse refreshToken(String refreshToken) {

        String username = jwtService.extractUsername(refreshToken);
        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (!jwtService.isTokenValid(refreshToken, user)) {
            throw new RuntimeException("Invalid token");
        }

        String newToken = jwtService.generateToken(user);

        return new AuthResponse(
                newToken,
                newToken,
                0L
        );
    }
}