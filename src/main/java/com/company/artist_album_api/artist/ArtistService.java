package com.company.artist_album_api.artist;

import com.company.artist_album_api.model.Artist;
import com.company.artist_album_api.repository.ArtistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Page<Artist> findAll(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }

    public Page<Artist> findByName(String name, Pageable pageable) {
        return artistRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist findById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public Artist update(Long id, Artist updatedArtist) {
        Artist artist = findById(id);
        artist.setName(updatedArtist.getName());
        return artistRepository.save(artist);
    }
}