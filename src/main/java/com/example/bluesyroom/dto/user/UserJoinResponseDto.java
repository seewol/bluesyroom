package com.example.bluesyroom.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserJoinResponseDto {
    // 회원번호, 이름

    private long userNo;

    private String userName;

    /*
    public UserJoinResponseDto(long userNo, String userName){
        this.userNo = userNo;
        this.userName = userName;
    }
    */
}
