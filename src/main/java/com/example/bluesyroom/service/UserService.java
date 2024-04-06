package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.user.UserLoginRequestDto;
import com.example.bluesyroom.dto.user.UserLoginResponseDto;
import com.example.bluesyroom.entity.RoleType;
import com.example.bluesyroom.entity.User;
import com.example.bluesyroom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // dao => repository
    @Autowired
    UserRepository userRepository;

    public UserJoinResponseDto joinUser(UserJoinRequestDto dto){

        User user = new User(dto.getUserId(), dto.getUserPw(), dto.getUserName(),
                dto.getPhone(), dto.getEmail(), "local", RoleType.USER);

        // 여기는 DB 저장 후의 상태라 userNo, createdAt이 들어있음
        User result = userRepository.save(user);

        return new UserJoinResponseDto(result.getUserNo(), result.getUserName());
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto dto){

        // dto(Request) - entity - dto(Response)

        User result = null;

        try {
            result = userRepository.findByUserId(dto.getUserId());
        } catch (Exception e){

        }

        if (dto.getUserPw().equals(result.getUserPw())){
            return new UserLoginResponseDto(1);
        } else {
            return new UserLoginResponseDto(0);
        }
    }
}
