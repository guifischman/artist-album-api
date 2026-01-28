package com.company.artist_album_api.album;

import com.company.artist_album_api.album.dto.AlbumRequest;
import com.company.artist_album_api.album.dto.AlbumResponse;
import com.company.artist_album_api.album.AlbumRepository;
import com.company.artist_album_api.artist.ArtistRepository;
import com.company.artist_album_api.model.Album;
import com.company.artist_album_api.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository albumRepository,
                        ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    public AlbumResponse create(AlbumRequest request) {

        Set<Artist> artists = artistRepository.findAllById(request.getArtistIds())
                .stream()
                .collect(Collectors.toSet());

        Album album = new Album();
        album.setTitle(request.getTitle());
        album.setArtists(artists);

        Album saved = albumRepository.save(album);
        return toResponse(saved);
    }

    public Page<AlbumResponse> findAll(Pageable pageable) {
        return albumRepository.findAll(pageable)
                .map(this::toResponse);
    }

    private AlbumResponse toResponse(Album album) {

        Set<String> artistNames = album.getArtists()
                .stream()
                .map(Artist::getName)
                .collect(Collectors.toSet());

        Set<String> artistTypes = album.getArtists()
                .stream()
                .map(artist -> artist.getType().name())
                .collect(Collectors.toSet());

        return new AlbumResponse(
                album.getId(),
                album.getTitle(),
                artistNames,
                artistTypes
        );
    }
}