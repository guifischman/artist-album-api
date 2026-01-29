package com.company.artist_album_api.artist.dto;

import com.company.artist_album_api.model.Artist;

public record ArtistSummaryResponse(
        Long id,
        String name
) {
    public static ArtistSummaryResponse fromEntity(Artist artist) {
        return new ArtistSummaryResponse(
                artist.getId(),
                artist.getName()
        );
    }
}