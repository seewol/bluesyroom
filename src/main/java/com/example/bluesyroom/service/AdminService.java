package com.example.bluesyroom.service;

import com.example.bluesyroom.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    PasswordEncoder encoder;    // Bcrypt

    @Autowired
    TokenProvider tokenProvider; // 토큰 발급

}
