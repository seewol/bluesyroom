package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.Product;
import com.example.bluesyroom.entity.User;
import com.example.bluesyroom.entity.Wish;
import org.springframework.data.repository.CrudRepository;

public interface WishRepository extends CrudRepository<Wish, Long> {
                                        // Wish랑 관련된 저장소 정의

    public Wish findByUserAndProduct(User user, Product product);

    /*
        JPA는 엔터티 단위로 동작하기 때문에
        Wish 엔터티 안에 있는 정보는 long 타입의 userNo이 아니라,
        User 타입의 user인 것이다. (product도 마찬가지)
        ▷ 따라서 조회 시에도 엔터티 단위로 조회해야 한다.
    */

}
