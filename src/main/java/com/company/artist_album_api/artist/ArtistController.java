package com.company.artist_album_api.artist;

import com.company.artist_album_api.artist.dto.ArtistRequest;
import com.company.artist_album_api.artist.dto.ArtistResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ArtistResponse create(@RequestBody ArtistRequest request) {
        return artistService.create(request);
    }

    @PutMapping("/{id}")
    public ArtistResponse update(
            @PathVariable Long id,
            @RequestBody ArtistRequest request
    ) {
        return artistService.update(id, request);
    }

    @GetMapping
    public Page<ArtistResponse> findAll(
            @RequestParam(required = false) String name,
            Pageable pageable
    ) {
        if (name != null && !name.isBlank()) {
            return artistService.findByName(name, pageable);
        }
        return artistService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ArtistResponse findById(@PathVariable Long id) {
        return artistService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistService.delete(id);
    }
}