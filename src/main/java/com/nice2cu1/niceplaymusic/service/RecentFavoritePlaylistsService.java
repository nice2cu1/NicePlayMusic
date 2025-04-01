package com.nice2cu1.niceplaymusic.service;

import java.util.List;
import java.util.Map;


public interface RecentFavoritePlaylistsService {
    List<Map<String, Object>> getRecentFavoritePlaylists(Integer userId);

    void updatePlays(Integer id, int plays);
}
