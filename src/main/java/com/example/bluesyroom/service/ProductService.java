package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.product.ProductInsertRequestDto;
import com.example.bluesyroom.dto.product.ProductInsertResponseDto;
import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.dto.user.UserLoginRequestDto;
import com.example.bluesyroom.dto.user.UserLoginResponseDto;
import com.example.bluesyroom.entity.*;
import com.example.bluesyroom.exception.CustomException;
import com.example.bluesyroom.repository.*;
import com.example.bluesyroom.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.bluesyroom.apiResponse.ErrorCode.*;

@Service
public class ProductService {
    // dao => repository
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductOptionRepository productOptionRepository;

    @Autowired
    ProductOptionDetailepository productOptionDetailepository;

    public ProductInsertResponseDto insertProduct(ProductInsertRequestDto dto) {

        // 상품 카테고리
        ProductCategory productCategory = productCategoryRepository.findById(dto.getProductCategoryNo())
                .orElseThrow(() -> new CustomException(PRODUCT_NO_NOT_FOUND));

        // 옵션 제목
        ProductOption productOption = new ProductOption(dto.getOptionEx());
        ProductOption saveProductOption = productOptionRepository.save(productOption);

        // 옵션 상세
        for (String detail : dto.getOptionDetails()) {
            ProductOptionDetail productOptionDetail = new ProductOptionDetail(detail, saveProductOption);
            ProductOptionDetail saveProductOptionDetail = productOptionDetailepository.save(productOptionDetail);
        }

        // 상품 등록
        Product product = new Product(dto.getProductName(), dto.getProductContent(), dto.getPrice(), dto.getProductQuantity(),
                productCategory);

        // 여기는 DB 저장 후의 상태라 userNo, createdAt이 추가로 들어있음
        Product result = productRepository.save(product);

        // 상품 옵션에 상품 등록하기 (연관관계 설정을 위해)
        productOption.setProduct(result);

        // product 필드가 추가된 productOption DB 수정
        ProductOption optionResult = productOptionRepository.save(productOption);

        return new ProductInsertResponseDto(result.getProductNo());
    }
}