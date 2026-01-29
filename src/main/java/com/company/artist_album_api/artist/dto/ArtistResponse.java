package com.company.artist_album_api.artist.dto;

import com.company.artist_album_api.model.Artist;
import com.company.artist_album_api.model.ArtistType;

public class ArtistResponse {

    private Long id;
    private String name;
    private ArtistType type;

    public ArtistResponse(Long id, String name, ArtistType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public static ArtistResponse fromEntity(Artist artist) {
        return new ArtistResponse(
                artist.getId(),
                artist.getName(),
                artist.getType()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistType getType() {
        return type;
    }
}