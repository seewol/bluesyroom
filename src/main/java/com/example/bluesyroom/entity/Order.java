package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ORDER")
public class Order {

    @Id
    @Column(name = "ORDER_NO", nullable = false)
    private long orderNo;

    @Column(name = "CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "ADDRESS_DETAIL", nullable = false)
    private String addressDetail;

    @Column(name = "RECIPIENT", nullable = false)
    private String recipient;

    @Column(name = "DELIVERY_MEMO",nullable = false)
    private String deliveryMemo;

    @Column(name = "ORDER_STATUS", nullable = false)
    private String orderStatus;

    @Column(name = "DELIVERY_PRICE", nullable = false)
    private long deliveryPrice;

    @Column(name = "ORDER_PRICE", nullable = false)
    private long orderPrice;

    @ManyToOne
    @JoinColumn(name="USER_NO")
    private User user;

}
