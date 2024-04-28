package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.user.UserLoginRequestDto;
import com.example.bluesyroom.dto.user.UserLoginResponseDto;
import com.example.bluesyroom.entity.RoleType;
import com.example.bluesyroom.entity.User;
import com.example.bluesyroom.exception.CustomException;
import com.example.bluesyroom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.bluesyroom.apiResponse.ErrorCode.USER_DUPLICATE_ID;
import static com.example.bluesyroom.apiResponse.ErrorCode.USER_WRONG_PW;

@Service
public class UserService {
    // dao => repository
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    public UserJoinResponseDto joinUser(UserJoinRequestDto dto){

        User findUserId = userRepository.findByUserId(dto.getUserId());
        // User findUserPhone = userRepository
        // User findUserEmail = userRepository.......

        if(findUserId != null){
            throw new CustomException(USER_DUPLICATE_ID);
        }


        User user = new User(dto.getUserId(), encoder.encode(dto.getUserPw()), dto.getUserName(),
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

        if (encoder.matches(dto.getUserPw(), result.getUserPw())){
            return new UserLoginResponseDto(1);
        } else {
//            return new UserLoginResponseDto(0);
            throw new CustomException(USER_WRONG_PW);
        }
    }
}
