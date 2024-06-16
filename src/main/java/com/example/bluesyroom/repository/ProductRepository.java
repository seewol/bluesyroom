package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.Product;
import com.example.bluesyroom.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
                                        // Prouduct랑 관련된 저장소 정의

}
