package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
                                        // User랑 관련된 저장소 정의
}
