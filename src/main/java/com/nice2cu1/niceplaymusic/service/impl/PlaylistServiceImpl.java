package com.nice2cu1.niceplaymusic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nice2cu1.niceplaymusic.mapper.PlaylistMapper;
import com.nice2cu1.niceplaymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistMapper playlistMapper;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public Map<String, Object> getPlaylistWithSongs(Long playlistId) {
        Map<String, Object> result = playlistMapper.getPlaylistWithSongs(playlistId);
        if (result.get("songs") != null) {
            try {
                // 解析 JSON 字符串为 List
                List<Map<String, Object>> songs = objectMapper.readValue(
                        result.get("songs").toString(), List.class
                );
                result.put("songs", songs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> getPlayListByUserId(Long userId) {
        return Map.of();
    }
}
