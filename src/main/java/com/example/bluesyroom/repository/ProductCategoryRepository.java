package com.example.bluesyroom.repository;

import com.example.bluesyroom.entity.Product;
import com.example.bluesyroom.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
                                        // Prouduct랑 관련된 저장소 정의

}
