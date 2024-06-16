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
    private String optionEx;
    private List<String> optionDetails;

}
