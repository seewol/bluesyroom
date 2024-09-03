package com.example.bluesyroom.controller;

import com.example.bluesyroom.apiResponse.ApiResponse;
import com.example.bluesyroom.dto.product.ProductInsertRequestDto;
import com.example.bluesyroom.dto.product.ProductInsertResponseDto;
import com.example.bluesyroom.dto.product.ProductSelectResponseDto;
import com.example.bluesyroom.dto.user.UserJoinRequestDto;
import com.example.bluesyroom.dto.user.UserJoinResponseDto;
import com.example.bluesyroom.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "상품 조회", description = "상품 조회입니다")
    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<ProductSelectResponseDto> selectProduct(@PathVariable(name = "id") long id) throws Exception{
        return ApiResponse.OK(productService.selectProduct(id));
    }


    @Operation(summary = "상품 목록 조회", description = "상품 목록 조회입니다")
    @GetMapping("")
    public @ResponseBody ApiResponse<List<ProductSelectResponseDto>> listSelectProduct() throws Exception{
        return ApiResponse.OK(productService.listSelectProduct());
    }
}
