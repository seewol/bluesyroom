package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.Product;
import com.example.bluesyroom.entity.ProductOption;
import com.example.bluesyroom.entity.ProductOptionDetail;
import org.springframework.data.repository.CrudRepository;

public interface ProductOptionRepository extends CrudRepository<ProductOption, Long> {
                                        // ProuductOption랑 관련된 저장소 정의

}
