package com.example.bluesyroom.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductInsertRequestDto {

    private Long productCategoryNo;
    private String productName;
    private String productContent;
    private int price;
    private int productQuantity;
    private List<ProductOptionInsertRequestDto> optionDtoList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ProductOptionInsertRequestDto {
        private String optionEx;
        private List<String> optionDetails;
    }

}
/*
optionDtoList : {
    [{optionEx: 설명1, optionDetails: {["빨", "주", "노"]}},
        {optionEx: 설명2, optionDetails: {["S", "M", "L"]}}]
        }

 */