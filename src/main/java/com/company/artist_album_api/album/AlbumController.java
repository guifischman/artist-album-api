package com.company.artist_album_api.album;

import com.company.artist_album_api.model.Album;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album create(@RequestBody Album album) {
        return albumService.save(album);
    }

    @GetMapping
    public List<Album> list() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable Long id) {
        return albumService.findById(id);
    }
}