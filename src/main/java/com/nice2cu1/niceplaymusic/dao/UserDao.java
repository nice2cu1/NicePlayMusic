package com.nice2cu1.niceplaymusic.dao;

import com.nice2cu1.niceplaymusic.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from users where email = #{email} and password = #{password}")
    User loginByEmail(String email, String password);

    @Select("select * from users where username = #{username} and password = #{password}")
    User loginByUsername(String username, String password);
}