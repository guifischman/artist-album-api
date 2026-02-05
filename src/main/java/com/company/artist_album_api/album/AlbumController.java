package com.company.artist_album_api.album;

import com.company.artist_album_api.album.dto.AlbumRequest;
import com.company.artist_album_api.album.dto.AlbumResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public Page<AlbumResponse> findAll(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long artistId,
            Pageable pageable
    ) {
        if (title != null) {
            return albumService.findByTitle(title, pageable);
        }
        if (artistId != null) {
            return albumService.findByArtist(artistId, pageable);
        }
        return albumService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AlbumResponse findById(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumResponse create(@RequestBody AlbumRequest request) {
        return albumService.create(request);
    }

    @PutMapping("/{id}")
    public AlbumResponse update(
            @PathVariable Long id,
            @RequestBody AlbumRequest request
    ) {
        return albumService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        albumService.delete(id);
    }
}