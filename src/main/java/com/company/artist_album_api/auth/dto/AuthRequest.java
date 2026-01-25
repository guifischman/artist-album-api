package com.company.artist_album_api.auth.dto;

public record AuthRequest(
        String username,
        String password
) {}
