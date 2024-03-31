package com.example.bluesyroom.controller;

import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    public UserJoinResponseDto joinUser(UserJoinRequestDto request){

        return userService.joinUser(request);
    }
}
