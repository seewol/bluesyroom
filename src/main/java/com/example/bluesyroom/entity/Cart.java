package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_NO", nullable = false)
    private long cartNo;

    @Column(name = "CART_QUANTITY", nullable = false)
    private long cartQuantity;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;

}
