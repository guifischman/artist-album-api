package com.company.artist_album_api.repository;

import com.company.artist_album_api.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Page<Artist> findByNameContainingIgnoreCase(String name, Pageable pageable);

}