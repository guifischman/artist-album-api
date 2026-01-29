package com.company.artist_album_api.album;

import com.company.artist_album_api.album.dto.AlbumRequest;
import com.company.artist_album_api.album.dto.AlbumResponse;
import com.company.artist_album_api.artist.ArtistRepository;
import com.company.artist_album_api.model.Album;
import com.company.artist_album_api.model.Artist;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository albumRepository,
                        ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    public Page<AlbumResponse> findAll(Pageable pageable) {
        return albumRepository.findAll(pageable)
                .map(AlbumResponse::fromEntity);
    }

    public AlbumResponse findById(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Álbum não encontrado"));
        return AlbumResponse.fromEntity(album);
    }

    public Page<AlbumResponse> findByTitle(String title, Pageable pageable) {
        return albumRepository.findByTitleContainingIgnoreCase(title, pageable)
                .map(AlbumResponse::fromEntity);
    }

    public Page<AlbumResponse> findByArtist(Long artistId, Pageable pageable) {
        return albumRepository.findByArtistId(artistId, pageable)
                .map(AlbumResponse::fromEntity);
    }

    public AlbumResponse create(AlbumRequest request) {

        Set<Artist> artists = new HashSet<>(
                artistRepository.findAllById(request.artistIds())
        );

        if (artists.isEmpty()) {
            throw new EntityNotFoundException("Nenhum artista encontrado para os IDs informados");
        }

        Album album = new Album();
        album.setTitle(request.title());
        album.setReleaseDate(request.releaseDate());
        album.setArtists(artists);

        return AlbumResponse.fromEntity(albumRepository.save(album));
    }

    public AlbumResponse update(Long id, AlbumRequest request) {

        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Álbum não encontrado"));

        Set<Artist> artists = new HashSet<>(
                artistRepository.findAllById(request.artistIds())
        );

        album.setTitle(request.title());
        album.setReleaseDate(request.releaseDate());
        album.setArtists(artists);

        return AlbumResponse.fromEntity(albumRepository.save(album));
    }

    public void delete(Long id) {
        if (!albumRepository.existsById(id)) {
            throw new EntityNotFoundException("Álbum não encontrado");
        }
        albumRepository.deleteById(id);
    }
}