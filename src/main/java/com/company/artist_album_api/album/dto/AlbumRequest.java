package com.company.artist_album_api.album.dto;

import java.time.LocalDate;
import java.util.List;

public record AlbumRequest(
        String title,
        LocalDate releaseDate,
        List<Long> artistIds
) {
}