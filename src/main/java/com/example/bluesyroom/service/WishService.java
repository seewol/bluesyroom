package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.user.UserLoginRequestDto;
import com.example.bluesyroom.dto.user.UserLoginResponseDto;
import com.example.bluesyroom.dto.wish.WishResponseDto;
import com.example.bluesyroom.entity.Product;
import com.example.bluesyroom.entity.RoleType;
import com.example.bluesyroom.entity.User;
import com.example.bluesyroom.entity.Wish;
import com.example.bluesyroom.exception.CustomException;
import com.example.bluesyroom.repository.ProductRepository;
import com.example.bluesyroom.repository.UserRepository;
import com.example.bluesyroom.repository.WishRepository;
import com.example.bluesyroom.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.bluesyroom.apiResponse.ErrorCode.*;

@Service
public class WishService {
    // dao => repository

    @Autowired
    WishRepository wishRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public WishResponseDto wish(String userId, long productNo){

        // User 찾기
        User user = userRepository.findByUserId(userId)
                .orElseThrow( ()-> new CustomException(USER_NOT_FOUND));

        // Product 찾기
        Product product = productRepository.findById(productNo)
                .orElseThrow( ()-> new CustomException(PRODUCT_NOT_FOUND));

        WishResponseDto dto = new WishResponseDto(user.getUserNo(), productNo);
        Wish wish = wishRepository.findByUserAndProduct(user, product);

        if (wish == null){
            Wish newWish = new Wish(user, product);
            wishRepository.save(newWish);
            dto.setStatus(1);
        } else {
            wishRepository.delete(wish);
            dto.setStatus(0);
        }

        return dto;

        /*
            1. Wish 테이블에서 찜 여부를 조회한다.
                1-1. userNo과 productNo이 동시에 부합하는 데이터를 찾기
                1-2. 있으면, Wish Entity 형태로 한 줄 가져옴
                1-3. 없으면, 없으니까 null
            2. 찜이 되어있다면 찜 취소
                2-1. (1-2)를 참고하여 wishNo을 기준으로 삭제 후 세이브
            3. 찜이 되어있지 않다면 찜 하기
                3-1. (1-3)을 참고하여 null이면, 새로운 Wish Entity 생성 후 세이브
         */

    }

}
