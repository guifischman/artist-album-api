package com.company.artist_album_api.artist;

import com.company.artist_album_api.model.Artist;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> searchByName(String name, boolean asc) {
        return asc
            ? artistRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name)
            : artistRepository.findByNameContainingIgnoreCaseOrderByNameDesc(name);
    }
}