package com.example.bluesyroom.controller;

import com.example.bluesyroom.apiResponse.ApiResponse;
import com.example.bluesyroom.customAnnotation.UserAuthorize;
import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.wish.WishResponseDto;
import com.example.bluesyroom.service.UserService;
import com.example.bluesyroom.service.WishService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@UserAuthorize
@RestController
@RequestMapping("/wish")
public class WishController {

    @Autowired
    WishService wishService;

    @Operation(summary = "찜", description = "찜 추가, 취소 기능입니다.")
    @PostMapping("/{productNo}")                                        // SecurityContextHolder에 담아둔 유저 정보 꺼내오기
    public @ResponseBody ApiResponse<WishResponseDto> wish(@AuthenticationPrincipal User user, @PathVariable(name="productNo") long productNo) throws Exception{
        System.out.println(user.getUsername());
        return ApiResponse.OK(wishService.wish(user.getUsername(), productNo));
                                        // ★ context 홀더에 username이 userid(String)으로 저장되고 있었음!!!!
        // 이 USER는 내가 만든 유저가 아님. Spring Security에서 제공하는 것.
        // 우리는 Username(보통 식별할 수 있는 것을 담음)에 userNo를 넣어놓기로 임의로 정함.
    }

}
