package com.company.artist_album_api.album;

import com.company.artist_album_api.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Page<Album> findAll(Pageable pageable);
}