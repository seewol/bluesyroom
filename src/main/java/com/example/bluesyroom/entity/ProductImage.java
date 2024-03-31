package com.example.bluesyroom.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT_IMAGE")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_NO", nullable = false)
    private long imageNo;

    @Column(name = "IMAGE_URL", nullable = false)
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;
}
