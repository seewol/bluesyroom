package com.example.bluesyroom.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.bluesyroom.entity.ProductImage;

@Entity
@NoArgsConstructor
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

    @Column(name = "PRODUCT_QUANTITY", nullable = false)
    private int productQuantity;

    // 테이블 생성과 조인은 이후에 따로 진행할 수 있음

    @OneToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_NO")
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList = new ArrayList<ProductImage>();

    @OneToMany(mappedBy = "product")
    private List<ProductOption> productOptionList = new ArrayList<>();

    public Product(String productName, String productContent, int price, int productQuantity, ProductCategory productCategory) {
        this.productName = productName;
        this.productContent = productContent;
        this.price = price;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }
}
