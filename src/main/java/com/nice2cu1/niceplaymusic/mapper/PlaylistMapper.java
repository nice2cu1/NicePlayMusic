package com.nice2cu1.niceplaymusic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface PlaylistMapper {

    @Select("SELECT p.id AS playlist_id, p.name AS playlist_name, p.description, " +
            "p.is_public, p.created_at, " +
            "(SELECT JSON_ARRAYAGG(JSON_OBJECT(" +
            "'id', s.id, 'title', s.title, 'artist', s.artist, 'genre', s.genre, " +
            "'file_path', s.file_path, 'cover_path', s.cover_path, 'lrc_path', s.lrc_path, " +
            "'duration', s.duration)) " +
            "FROM niceplaymusic.playlist_songs ps " +
            "JOIN niceplaymusic.songs s ON ps.song_id = s.id " +
            "WHERE ps.playlist_id = p.id) AS songs " +
            "FROM niceplaymusic.playlists p " +
            "WHERE p.id = #{playlistId}")
    Map<String, Object> getPlaylistWithSongs(@Param("playlistId") Long playlistId);

    @Select("SELECT p.id AS playlist_id, p.name AS playlist_name, p.description, " +
            "p.is_public, p.created_at " +
            "FROM niceplaymusic.playlists p " +
            "WHERE p.user_id = #{userId}")
    Map<String, Object> getPlayListByUserId(@Param("userId") Long userId);
}
