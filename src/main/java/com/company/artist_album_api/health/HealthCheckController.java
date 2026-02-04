package com.company.artist_album_api.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/liveness")
    public ResponseEntity<Map<String, Object>> liveness() {
        return ResponseEntity.ok(
                Map.of(
                        "status", "UP",
                        "service", "artist-album-api",
                        "timestamp", Instant.now().toString()
                )
        );
    }

    @GetMapping("/readiness")
    public ResponseEntity<Map<String, Object>> readiness() {
        return ResponseEntity.ok(
                Map.of(
                        "status", "READY",
                        "service", "artist-album-api",
                        "timestamp", Instant.now().toString()
                )
        );
    }
}