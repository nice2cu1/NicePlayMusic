package com.nice2cu1.niceplaymusic.service.impl;

import com.nice2cu1.niceplaymusic.dao.UserDao;
import com.nice2cu1.niceplaymusic.pojo.User;
import com.nice2cu1.niceplaymusic.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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

    @Override
    public Map<String, Object> uploadAvatars(byte[] fileContent, Map<String, String> headers) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach(httpHeaders::set);
        HttpEntity<byte[]> requestEntity = new HttpEntity<>(fileContent, httpHeaders);
        ResponseEntity<Map> response = restTemplate.exchange("http://8.217.105.136:5244/api/fs/put", HttpMethod.PUT, requestEntity, Map.class);
        return response.getBody();
    }

    public void updateAvatar(int id, String avatarUrl) {
        userDao.updateAvatar(id, avatarUrl);
    }

}