package com.nice2cu1.niceplaymusic.service;

import com.nice2cu1.niceplaymusic.pojo.User;

public interface UserService {

    /**
     * 登录方法
     *
     * @param identifier 用户名或邮箱
     * @param password   密码
     * @return 登录结果
     */
    User login(String identifier, String password);
}
