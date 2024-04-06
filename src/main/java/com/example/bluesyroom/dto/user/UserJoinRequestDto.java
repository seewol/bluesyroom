package com.example.bluesyroom.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserJoinRequestDto {
    // 아이디, 비밀번호, 이름, 휴대폰 번호, 이메일

    private String userId;
    private String userPw;
    private String userName;
    private String phone;
    private String email;

}
