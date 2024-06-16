package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter         // 상품 옵션 상세
@Table(name = "PRODUCT_OPTION_DETAIL")
public class ProductOptionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_DETAIL_NO", nullable = false)
    private long optionDetailNo;

    @Column(name = "OPTION_CONTENT", nullable = false)
    private String optionContent;

    @ManyToOne
    @JoinColumn(name = "OPTION_NO")
    private ProductOption productOption;

    public ProductOptionDetail(String optionContent, ProductOption productOption) {
        this.optionContent = optionContent;
        this.productOption = productOption;
    }
}
