package com.nice2cu1.niceplaymusic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice2cu1.niceplaymusic.mapper.PlaylistMapper;
import com.nice2cu1.niceplaymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.text.StringEscapeUtils;

import java.util.Map;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistMapper playlistMapper;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public Map<String, Object> getPlaylistWithSongs(Integer playlistId) {
        Map<String, Object> result = playlistMapper.getPlaylistWithSongs(playlistId);
        if (result.get("songs") != null) {
            try {
                // 解析 JSON 字符串为 List
                List<Map<String, Object>> songs = objectMapper.readValue(
                        result.get("songs").toString(), List.class
                );
                // 处理 banner_lrc 字段中的转义字符
                for (Map<String, Object> song : songs) {
                    if (song.containsKey("banner_lrc") && song.get("banner_lrc") instanceof String) {
                        String bannerLrc = (String) song.get("banner_lrc");
                        song.put("banner_lrc", StringEscapeUtils.unescapeJava(bannerLrc));
                    }
                }
                result.put("songs", songs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> getPlayListByUserId(Integer userId) {
        List<Map<String, Object>> playlists = playlistMapper.getPlaylistsByUserId(userId);
        return Map.of("playlists", playlists);
    }

    @Override
    public Map<String, Object> getAppleMusicPlaylist() {
        List<Map<String, Object>> appleMusicPlaylists = playlistMapper.getAppleMusicPlaylist();
        return Map.of("appleMusicPlaylists", appleMusicPlaylists);
    }

    @Override
    public Map<String, Object> getRecommendPlaylist() {
        List<Map<String, Object>> recommendPlaylists = playlistMapper.getRecommendPlaylist();
        return Map.of("recommendPlaylists", recommendPlaylists);
    }

}
