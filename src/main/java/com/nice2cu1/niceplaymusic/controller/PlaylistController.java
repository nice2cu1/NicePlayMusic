package com.nice2cu1.niceplaymusic.controller;

import com.nice2cu1.niceplaymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/{playlistId}")
    public Map<String, Object> getPlaylistWithSongs(@PathVariable Long playlistId) {
        return playlistService.getPlaylistWithSongs(playlistId);
    }
}
