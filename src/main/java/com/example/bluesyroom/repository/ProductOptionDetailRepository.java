package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.ProductOptionDetail;
import org.springframework.data.repository.CrudRepository;

public interface ProductOptionDetailRepository extends CrudRepository<ProductOptionDetail, Long> {
                                        // ProuductOptionDetail이랑 관련된 저장소 정의

}
