package com.nice2cu1.niceplaymusic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecentFavoritePlaylistsMapper {

    @Select("SELECT rfp.id AS recent_favorite_id, rfp.playlist_id, rfp.name, rfp.cover_url, rfp.description, rfp.created_at, " +
            "p.name AS playlist_name,p.tracks,p.plays, p.is_public, p.created_at AS playlist_created_at " +
            "FROM recent_favorite_playlists rfp " +
            "JOIN playlists p ON rfp.playlist_id = p.id " +
            "WHERE rfp.user_id = #{userId}")
    List<Map<String, Object>> getRecentFavoritePlaylists(@Param("userId") Integer userId);

    @Update("UPDATE playlists SET plays = #{plays} WHERE id = #{id}")
    void updatePlays(@Param("id") Integer id, @Param("plays") int plays);
}
