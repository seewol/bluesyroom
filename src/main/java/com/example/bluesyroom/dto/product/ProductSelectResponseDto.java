package com.example.bluesyroom.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductSelectResponseDto {
    // ★★★★★★★★★★★★★★★★★★★
    // optionEx를 List로 바꿔서 innetClass 변경 하고 ~~~~

    private long productNo;
    private Long productCategoryNo;
    private String productName;
    private String productContent;
    private int price;
    private int productQuantity;
    private List<productOptionSelectResponseDto> optionDtoList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class productOptionSelectResponseDto {
        private String optionEx;
        private List<String> optionDetails;
    }

}
