package com.company.artist_album_api.album;

import com.company.artist_album_api.album.dto.AlbumRequest;
import com.company.artist_album_api.album.dto.AlbumResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @PostMapping
    public AlbumResponse create(@RequestBody @Valid AlbumRequest request) {
        return service.create(request);
    }

    @GetMapping
    public Page<AlbumResponse> list(Pageable pageable) {
        return service.findAll(pageable);
    }
}