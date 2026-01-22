package com.company.artist_album_api.album;

import com.company.artist_album_api.model.Album;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public Page<Album> list(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        return albumService.getAlbums(PageRequest.of(page, size));
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return albumService.save(album);
    }
}