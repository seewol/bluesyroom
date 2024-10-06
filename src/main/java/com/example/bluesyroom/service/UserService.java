package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.user.UserLoginRequestDto;
import com.example.bluesyroom.dto.user.UserLoginResponseDto;
import com.example.bluesyroom.entity.RoleType;
import com.example.bluesyroom.entity.User;
import com.example.bluesyroom.exception.CustomException;
import com.example.bluesyroom.repository.UserRepository;
import com.example.bluesyroom.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.bluesyroom.apiResponse.ErrorCode.*;

@Service
public class UserService {
    // dao => repository
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;    // Bcrypt

    @Autowired
    TokenProvider tokenProvider; // 토큰 발급

    public UserJoinResponseDto joinUser(UserJoinRequestDto dto){

        User findUserId = userRepository.findByUserId(dto.getUserId())
                .orElseThrow( ()-> new CustomException(USER_NOT_FOUND));
        // User findUserPhone = userRepository
        // User findUserEmail = userRepository.......

        if(findUserId != null){
            throw new CustomException(USER_DUPLICATE_ID);
        }


        User user = new User(dto.getUserId(), encoder.encode(dto.getUserPw()), dto.getUserName(),
                dto.getPhone(), dto.getEmail(), "local", RoleType.USER);

        // 여기는 DB 저장 후의 상태라 userNo, createdAt이 추가로 들어있음
        User result = userRepository.save(user);

        return new UserJoinResponseDto(result.getUserNo(), result.getUserName());
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto dto){

        // dto(Request) - entity - dto(Response)

        User result = null;

        // 로그인 ID, PW 확인
        result = userRepository.findByUserId(dto.getUserId())
                .orElseThrow( ()-> new CustomException(USER_NOT_FOUND));

        if (result == null){
            throw new CustomException(USER_WRONG_ID_PW);
        }

        if (encoder.matches(dto.getUserPw(), result.getUserPw())){
            String token = tokenProvider.createToken(String.format("%s:%s", result.getUserId(), result.getRoleType()));
            System.out.println(token);
            return new UserLoginResponseDto(1, token);
        } else {
            // return new UserLoginResponseDto(0);
            throw new CustomException(USER_WRONG_ID_PW);
        }
    }
}
