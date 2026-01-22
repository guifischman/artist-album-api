package com.company.artist_album_api.album;

import com.company.artist_album_api.model.Album;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Page<Album> getAlbums(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }
}