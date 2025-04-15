package com.nice2cu1.niceplaymusic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BannerMapper {
    @Select("SELECT b.id AS banner_id, b.song_id,b.banner_cover_url, b.cover_url, b.banner_title, b.banner_description, b.lrc, " +
            "s.title AS song_title, s.artist AS song_artist, s.genre AS song_genre, s.file_path, s.duration " +
            "FROM banner_songs b " +
            "JOIN songs s ON b.song_id = s.id")
    List<Map<String, Object>> getBannerSongs();
}
