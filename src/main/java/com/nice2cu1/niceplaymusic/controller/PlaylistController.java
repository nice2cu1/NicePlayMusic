package com.nice2cu1.niceplaymusic.controller;

import com.nice2cu1.niceplaymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/{playlistId}")
    public Map<String, Object> getPlaylistWithSongs(@PathVariable Integer playlistId) {
        return playlistService.getPlaylistWithSongs(playlistId);
    }

    @GetMapping("/user/{userId}")
    public Map<String, Object> getPlaylistsByUserId(@PathVariable Integer userId) {
        return playlistService.getPlayListByUserId(userId);
    }

    @GetMapping("/applemusic")
    public Map<String, Object> getAppleMusicPlaylist() {
        return playlistService.getAppleMusicPlaylist();
    }

    @GetMapping("/recommend")
    public Map<String, Object> getRecommendPlaylist() {
        return playlistService.getRecommendPlaylist();
    }
}
