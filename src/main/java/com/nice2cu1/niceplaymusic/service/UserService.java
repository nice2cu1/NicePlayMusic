package com.nice2cu1.niceplaymusic.service;

import com.nice2cu1.niceplaymusic.pojo.User;

import java.util.Map;

public interface UserService {

    /**
     * 登录方法
     *
     * @param identifier 用户名或邮箱
     * @param password   密码
     * @return 登录结果
     */
    User login(String identifier, String password);

    /**
     * 上传头像方法
     *
     * @param fileContent 头像文件内容
     * @param headers     请求头
     * @return 上传结果
     */
    Map<String, Object> uploadAvatars(byte[] fileContent, Map<String, String> headers);

    /**
     * 更新用户头像
     *
     * @param id        用户ID
     * @param avatarUrl 头像URL
     */
    void updateAvatar(int id, String avatarUrl);
}
