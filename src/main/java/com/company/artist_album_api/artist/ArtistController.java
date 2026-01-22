package com.company.artist_album_api.artist;

import com.company.artist_album_api.model.Artist;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> search(@RequestParam String name,
                               @RequestParam(defaultValue = "true") boolean asc) {
        return artistService.searchByName(name, asc);
    }
}