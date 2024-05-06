package com.example.bluesyroom.controller;

import com.example.bluesyroom.apiResponse.ApiResponse;
import com.example.bluesyroom.customAnnotation.UserAuthorize;
import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.user.UserLoginRequestDto;
import com.example.bluesyroom.dto.user.UserLoginResponseDto;
import com.example.bluesyroom.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@UserAuthorize
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "회원 가입", description = "회원 가입입니다")
    @PostMapping("")
    public @ResponseBody ApiResponse<UserJoinResponseDto> joinUser(@RequestBody UserJoinRequestDto request) throws Exception{
        return ApiResponse.OK(userService.joinUser(request));
    }

    @Operation(summary = "로그인", description = "로그인입니다")
    @PostMapping("/login")
    public @ResponseBody ApiResponse<UserLoginResponseDto> loginUser(@RequestBody UserLoginRequestDto request) throws Exception{
                                        // @ModelAttribute 생략된 것이나 마찬가지
        return ApiResponse.OK(userService.loginUser(request));
    }

}
