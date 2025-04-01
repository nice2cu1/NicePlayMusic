package com.nice2cu1.niceplaymusic.service;

import java.util.Map;

public interface PlaylistService {
    /**
     * 获取歌单及其包含的歌曲
     *
     * @param playlistId 歌单ID
     * @return 包含歌单信息和歌曲信息的Map
     */
    Map<String, Object> getPlaylistWithSongs(Long playlistId);

    /**
     * 获取用户的所有歌单
     *
     * @param userId 用户ID
     * @return 包含用户所有歌单信息的Map
     */
    Map<String, Object> getPlayListByUserId(Long userId);
}
