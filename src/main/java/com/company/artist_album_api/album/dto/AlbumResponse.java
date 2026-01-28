package com.company.artist_album_api.album.dto;

import java.util.Set;

public class AlbumResponse {

    private Long id;
    private String title;
    private Set<String> artists;
    private Set<String> artistTypes;

    public AlbumResponse(Long id,
                         String title,
                         Set<String> artists,
                         Set<String> artistTypes) {
        this.id = id;
        this.title = title;
        this.artists = artists;
        this.artistTypes = artistTypes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getArtists() {
        return artists;
    }

    public Set<String> getArtistTypes() {
        return artistTypes;
    }
}