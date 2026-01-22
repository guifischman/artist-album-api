package com.company.artist_album_api.artist;

import com.company.artist_album_api.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    List<Artist> findByNameContainingIgnoreCaseOrderByNameDesc(String name);
}