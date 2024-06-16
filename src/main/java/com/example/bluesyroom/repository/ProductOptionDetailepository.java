package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.ProductOption;
import com.example.bluesyroom.entity.ProductOptionDetail;
import org.springframework.data.repository.CrudRepository;

public interface ProductOptionDetailepository extends CrudRepository<ProductOptionDetail, Long> {
                                        // ProuductOptionDetail이랑 관련된 저장소 정의

}
