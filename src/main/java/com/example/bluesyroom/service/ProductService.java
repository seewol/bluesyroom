package com.example.bluesyroom.service;

import com.example.bluesyroom.dto.product.ProductInsertRequestDto;
import com.example.bluesyroom.dto.product.ProductInsertResponseDto;
import com.example.bluesyroom.dto.product.ProductSelectResponseDto;
import com.example.bluesyroom.entity.*;
import com.example.bluesyroom.exception.CustomException;
import com.example.bluesyroom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    ProductOptionDetailRepository productOptionDetailRepository;

    // 상품 등록
    public ProductInsertResponseDto insertProduct(ProductInsertRequestDto dto) {

        List<ProductOption> productOptionList = new ArrayList<>();

        // 상품 카테고리
        ProductCategory productCategory = productCategoryRepository.findById(dto.getProductCategoryNo())
                .orElseThrow(() -> new CustomException(PRODUCT_CATE_NO_NOT_FOUND));

                // 클래스 타입 ▼                                                         // 큰 옵션이 담긴 리스트
        for (ProductInsertRequestDto.ProductOptionInsertRequestDto getOptionDto : dto.getOptionDtoList()) {

            // 옵션 제목
            ProductOption productOption = new ProductOption(getOptionDto.getOptionEx());
            ProductOption saveProductOption = productOptionRepository.save(productOption);

            // 옵션 상세
            for (String detail : getOptionDto.getOptionDetails()) {
                ProductOptionDetail productOptionDetail = new ProductOptionDetail(detail, saveProductOption);
                ProductOptionDetail saveProductOptionDetail = productOptionDetailRepository.save(productOptionDetail);
            }

            productOptionList.add(saveProductOption); // ArrayList에 Option들을 저장해놓기
            // 왜냐? 아래에서 Option에 Product를 넣고 저장해야 하니까. (Option을 List에 담아 반복할 수 있게)
        }


        // 상품 진짜 등록
        Product product = new Product(dto.getProductName(), dto.getProductContent(), dto.getPrice(), dto.getProductQuantity(),
                productCategory);

        // 여기는 DB 저장 후의 상태라 userNo, createdAt이 추가로 들어있음
        Product result = productRepository.save(product);

        for(ProductOption productOption : productOptionList) {

            // 상품 옵션에 상품 등록하기 (연관관계 설정을 위해)
            productOption.setProduct(result);

            // product 필드가 추가된 productOption DB 수정
            ProductOption optionResult = productOptionRepository.save(productOption);

        }

        return new ProductInsertResponseDto(result.getProductNo());
    }


    // 상품 조회
    public ProductSelectResponseDto selectProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow( ()-> new CustomException(PRODUCT_NOT_FOUND));

        List<ProductSelectResponseDto.productOptionSelectResponseDto> optionDtoList = new ArrayList<>();

        // Option Entity List 를 Option Dto List로 바꾸는 과정 (꺼내는 거)
        for(ProductOption productOption : product.getProductOptionList()){
            // Entity List → Entity

            // Option 하나에 연결된 Option detail Entity List를 가져와 String 타입의 List detail에 넣어줌
            // 결국은 이 과정이 optionDto의 optionDetails 자리에 넣기 위함.
            List<String> detail = new ArrayList<>();
            for(ProductOptionDetail d : productOption.getProductOptionDetailList()){
                detail.add(d.getOptionContent());
            }

            ProductSelectResponseDto.productOptionSelectResponseDto optionDto = new ProductSelectResponseDto.productOptionSelectResponseDto(productOption.getOptionEx(), detail);
            // 위의 optionDtoList는 여러 개의 optionDto를 넣기 위해 만듦
            optionDtoList.add(optionDto);
        }

        return new ProductSelectResponseDto(product.getProductNo(), product.getProductCategory().getProductCategoryNo(), product.getProductName(), product.getProductContent(),
                product.getPrice(), product.getProductQuantity(), optionDtoList);
    }
}