package com.nice2cu1.niceplaymusic.service.impl;

import com.nice2cu1.niceplaymusic.mapper.RecentFavoritePlaylistsMapper;
import com.nice2cu1.niceplaymusic.service.RecentFavoritePlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecentFavoritePlaylistsServiceImpl implements RecentFavoritePlaylistsService {

    @Autowired
    private RecentFavoritePlaylistsMapper recentFavoritePlaylistsMapper;

    @Override
    public List<Map<String, Object>> getRecentFavoritePlaylists(Integer userId) {
        return recentFavoritePlaylistsMapper.getRecentFavoritePlaylists(userId);
    }

    @Override
    public void updatePlays(Integer id, int plays) {

    }
}
