package com.nice2cu1.niceplaymusic.mapper;

import com.nice2cu1.niceplaymusic.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from users where email = #{email} and password = #{password}")
    User loginByEmail(String email, String password);

    @Select("select * from users where username = #{username} and password = #{password}")
    User loginByUsername(String username, String password);

    @Update("update users set avatar = #{avatar} where id = #{id}")
    int updateAvatar(int id, String avatar);
}