package com.company.artist_album_api.artist.dto;

import com.company.artist_album_api.model.ArtistType;

public record ArtistResponse(
        Long id,
        String name,
        ArtistType type
) {}