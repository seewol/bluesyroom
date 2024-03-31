package com.example.bluesyroom.dto.user;

public class UserJoinResponseDto {
    // 회원번호, 이름

    private long userNo;

    private String userName;

    public UserJoinResponseDto(long userNo, String userName){
        this.userNo = userNo;
        this.userName = userName;
    }

}
