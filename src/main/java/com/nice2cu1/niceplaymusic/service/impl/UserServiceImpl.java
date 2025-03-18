package com.nice2cu1.niceplaymusic.service.impl;

import com.nice2cu1.niceplaymusic.dao.UserDao;
import com.nice2cu1.niceplaymusic.pojo.User;
import com.nice2cu1.niceplaymusic.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(String identifier, String password) {
        if (identifier.contains("@")) {
            return userDao.loginByEmail(identifier, password);
        } else {
            return userDao.loginByUsername(identifier, password);
        }
    }
}