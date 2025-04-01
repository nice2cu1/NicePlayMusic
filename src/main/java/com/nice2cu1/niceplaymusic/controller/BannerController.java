package com.nice2cu1.niceplaymusic.controller;

import com.nice2cu1.niceplaymusic.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banner-songs")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getBannerSongs() {
        List<Map<String, Object>> bannerSongs = bannerService.getBannerSongs();

        if (!bannerSongs.isEmpty()) {
            return ResponseEntity.ok(bannerSongs);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
