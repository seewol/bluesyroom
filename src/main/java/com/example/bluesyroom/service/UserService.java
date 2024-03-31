package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
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
}
