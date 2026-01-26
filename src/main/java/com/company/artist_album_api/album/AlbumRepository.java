package com.company.artist_album_api.album;

import com.company.artist_album_api.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}