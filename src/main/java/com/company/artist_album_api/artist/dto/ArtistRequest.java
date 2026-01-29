package com.company.artist_album_api.artist.dto;

import jakarta.validation.constraints.NotBlank;

public class ArtistRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}