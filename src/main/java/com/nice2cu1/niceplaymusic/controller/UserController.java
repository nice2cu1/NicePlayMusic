package com.nice2cu1.niceplaymusic.controller;


import com.nice2cu1.niceplaymusic.pojo.User;
import com.nice2cu1.niceplaymusic.service.UserService;
import com.nice2cu1.niceplaymusic.utils.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ApiResponse<Object> login(@RequestParam String identifier, @RequestParam String password) {
        System.out.println("Login attempt with identifier: " + identifier + " and password: " + password);
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        User result = userService.login(identifier, password);
        if (result == null) {
            apiResponse.setCode(400);
            apiResponse.setMessage("Login failed");
            apiResponse.setData(null);
        } else {
            apiResponse.setCode(200);
            apiResponse.setMessage("Login successful");
            apiResponse.setData(result);
        }
        return apiResponse;
    }

    @PutMapping("/uploadAvatars")
    public ApiResponse<Object> uploadAvatars(@RequestBody byte[] fileContent, @RequestParam("filename") String filename, @RequestParam("userId") int userId) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        String filePath = "/NicePlayMusic/avatars/" + filename;

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/octet-stream");
        headers.put("Authorization", "alist-054f2f91-6425-4454-8607-6e167c46de01XGTKZhQP5gMQmsUWRPJFcSGmHOPtdUHXsScugiROTOCPqVqhDofH32zaK1Ww2jgP");
        headers.put("File-Path", filePath);

        Map<String, Object> response = userService.uploadAvatars(fileContent, headers);
        if (response != null && (int) response.get("code") == 200) {
            userService.updateAvatar(userId, "http://8.217.105.136:5244/d" + filePath);
            apiResponse.setSuccess(true);
            apiResponse.setCode(200);
            apiResponse.setMessage("Upload successful");
            apiResponse.setData(response.get("message"));
        } else {
            apiResponse.setCode(500);
            apiResponse.setMessage("Upload failed");
            apiResponse.setData(null);
        }
        return apiResponse;
    }

}
