package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;

    @OneToMany(mappedBy = "productOption")
    private List<ProductOptionDetail> productOptionDetailList = new ArrayList<>();

    public ProductOption(String optionEx) {
        this.optionEx = optionEx;
    }
}
