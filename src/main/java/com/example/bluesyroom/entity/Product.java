package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter         // 상품
@Table(name = "PRODUCT")
public class Product {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increament
    @Column(name = "PRODUCT_NO", nullable = false)
    private long productNo;

    // DB 컬럼은 _ 사용
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_CONTENT", nullable = false)
    private String productContent;

    @Column(name = "PRICE", nullable = false)
    private int price;

    // 테이블 생성과 조인은 이후에 따로 진행할 수 있음

}
