package com.nice2cu1.niceplaymusic.controller;


import com.nice2cu1.niceplaymusic.pojo.User;
import com.nice2cu1.niceplaymusic.service.UserService;
import com.nice2cu1.niceplaymusic.utils.ApiResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
