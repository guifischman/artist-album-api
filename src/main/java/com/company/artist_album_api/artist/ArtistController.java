package com.company.artist_album_api.controller;

import com.company.artist_album_api.artist.ArtistService;
import com.company.artist_album_api.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<Page<Artist>> listArtists(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Artist> result = (name == null || name.isBlank())
                ? artistService.findAll(pageable)
                : artistService.findByName(name, pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Artist> create(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.save(artist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> update(
            @PathVariable Long id,
            @RequestBody Artist artist
    ) {
        return ResponseEntity.ok(artistService.update(id, artist));
    }
}