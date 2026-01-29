package com.company.artist_album_api.album;

import com.company.artist_album_api.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Page<Album> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("select a from Album a join a.artists ar where ar.id = :artistId")
    Page<Album> findByArtistId(@Param("artistId") Long artistId, Pageable pageable);
}