package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
                                        // User랑 관련된 저장소 정의
    public Optional<User> findByUserId(String id);

}
