package com.company.artist_album_api.artist.dto;

import com.company.artist_album_api.model.ArtistType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArtistRequest(

        @NotBlank
        @Size(max = 200)
        String name,

        @NotNull
        ArtistType type
) {}