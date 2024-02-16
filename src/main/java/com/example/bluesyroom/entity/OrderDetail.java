package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ORDER_DETAIL")
public class OrderDetail {

    @Id
    @Column(name = "ORDER_DETAIL_NO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailNo;

    @Column(name = "ORDER_QUANTITY", nullable = false)
    private long orderQuantity;

    @ManyToOne
    @JoinColumn(name = "ORDER_NO")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;

}
