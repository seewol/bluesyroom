package com.example.bluesyroom.controller;

import com.example.bluesyroom.apiResponse.ApiResponse;
import com.example.bluesyroom.dto.product.ProductInsertRequestDto;
import com.example.bluesyroom.dto.product.ProductInsertResponseDto;
import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "상품 등록", description = "상품 등록입니다")
    @PostMapping("")
    public @ResponseBody ApiResponse<ProductInsertResponseDto> insertProduct(@RequestBody ProductInsertRequestDto request) throws Exception{
        return ApiResponse.OK(productService.insertProduct(request));
    }
}
