package com.company.artist_album_api.artist;

import com.company.artist_album_api.artist.dto.ArtistRequest;
import com.company.artist_album_api.artist.dto.ArtistResponse;
import com.company.artist_album_api.common.exception.ResourceNotFoundException;
import com.company.artist_album_api.model.Artist;
import com.company.artist_album_api.model.ArtistType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Page<ArtistResponse> findAll(Pageable pageable) {
        return artistRepository
                .findAll(pageable)
                .map(ArtistResponse::fromEntity);
    }

    public Page<ArtistResponse> findByName(String name, Pageable pageable) {
        return artistRepository
                .findByNameContainingIgnoreCase(name, pageable)
                .map(ArtistResponse::fromEntity);
    }

    public ArtistResponse findById(Long id) {
        Artist artist = artistRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Artist not found with id " + id)
                );

        return ArtistResponse.fromEntity(artist);
    }

    public ArtistResponse create(ArtistRequest request) {
        Artist artist = new Artist();
        artist.setName(request.getName());
        artist.setType(ArtistType.valueOf(request.getType()));

        Artist saved = artistRepository.save(artist);
        return ArtistResponse.fromEntity(saved);
    }

    public ArtistResponse update(Long id, ArtistRequest request) {
        Artist artist = artistRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Artist not found with id " + id)
                );

        artist.setName(request.getName());
        artist.setType(ArtistType.valueOf(request.getType()));

        Artist updated = artistRepository.save(artist);
        return ArtistResponse.fromEntity(updated);
    }

    public void delete(Long id) {
        Artist artist = artistRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Artist not found with id " + id)
                );

        artistRepository.delete(artist);
    }
}