package com.company.artist_album_api.album.dto;

import com.company.artist_album_api.artist.dto.ArtistSummaryResponse;
import com.company.artist_album_api.model.Album;

import java.time.LocalDate;
import java.util.List;

public record AlbumResponse(
        Long id,
        String title,
        LocalDate releaseDate,
        List<ArtistSummaryResponse> artists
) {

    public static AlbumResponse fromEntity(Album album) {
        return new AlbumResponse(
                album.getId(),
                album.getTitle(),
                album.getReleaseDate(),
                album.getArtists()
                        .stream()
                        .map(ArtistSummaryResponse::fromEntity)
                        .toList()
        );
    }
}