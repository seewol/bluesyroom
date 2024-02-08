package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter         // 상품 옵션
@Table(name = "PRODUCT_OPTION")
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_NO", nullable = false)
    private long optionNo;

    @Column(name = "OPTION_EX", nullable = false)
    private String optionEx;

}
