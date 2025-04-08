package com.nice2cu1.niceplaymusic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.List;

@Mapper
public interface PlaylistMapper {

    @Select("SELECT p.id AS playlist_id, p.name AS playlist_name, p.description, " +
            "p.is_public, p.created_at, " +
            "(SELECT JSON_ARRAYAGG(JSON_OBJECT(" +
            "'id', s.id, 'title', s.title, 'artist', s.artist, 'banner_lrc', s.banner_lrc, " +
            "'file_path', s.file_path, 'cover_path', s.cover_path, 'lrc_path', s.lrc_path, " +
            "'duration', s.duration)) " +
            "FROM niceplaymusic.playlist_songs ps " +
            "JOIN niceplaymusic.songs s ON ps.song_id = s.id " +
            "WHERE ps.playlist_id = p.id) AS songs " +
            "FROM niceplaymusic.playlists p " +
            "WHERE p.id = #{playlistId}")
    Map<String, Object> getPlaylistWithSongs(@Param("playlistId") Integer playlistId);

    @Select("SELECT id, name, description, cover_url, plays, tracks, created_at " +
            "FROM niceplaymusic.playlists " +
            "WHERE user_id = #{userId} AND is_public = 1")
    List<Map<String, Object>> getPlaylistsByUserId(@Param("userId") Integer userId);

    @Select("SELECT id, name, description, cover_url, plays, tracks, created_at " +
            "FROM niceplaymusic.playlists " +
            "WHERE user_id = 1 AND description = 'By Apple Music' || description = 'by ZUTOMAYO'")
    List<Map<String, Object>> getAppleMusicPlaylist();

    @Select("SELECT id, name, description, cover_url, plays, tracks, created_at " +
            "FROM niceplaymusic.playlists " +
            "WHERE user_id = 1 " +
            "AND name NOT IN ('今日推荐', '排行榜', '轮播推荐') AND is_public = 1")
    List<Map<String, Object>> getRecommendPlaylist();
}
