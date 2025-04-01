package com.nice2cu1.niceplaymusic.controller;

import com.nice2cu1.niceplaymusic.service.RecentFavoritePlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recent-favorite-playlists")
public class RecentFavoritePlaylistsController {

    @Autowired
    private RecentFavoritePlaylistsService recentFavoritePlaylistsService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getRecentFavoritePlaylists(@PathVariable Integer userId) {
        List<Map<String, Object>> playlists = recentFavoritePlaylistsService.getRecentFavoritePlaylists(userId);

        if (!playlists.isEmpty()) {
            return ResponseEntity.ok(playlists);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/{id}/update-plays")
    public ResponseEntity<Void> updatePlays(@PathVariable Integer id, @RequestParam int plays) {
        recentFavoritePlaylistsService.updatePlays(id, plays);
        return ResponseEntity.ok().build();
    }
}
