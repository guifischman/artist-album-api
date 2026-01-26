package com.company.artist_album_api.artist;

import com.company.artist_album_api.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}