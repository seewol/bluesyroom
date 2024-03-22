package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "COUPON")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUPON_NO", nullable = false)
    private long couponNo;

    @Column(name = "COUPON_TYPE", nullable = false)
    private long couponType;

    @Column(name = "BASE_AMOUNT", nullable = false)
    private long baseAmount;

}
