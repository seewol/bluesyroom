package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "COUPON_DETAIL")
public class CouponDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUPON_SN", nullable = false)
    private long couponSn;

    @ManyToOne
    @JoinColumn(name = "COUPON_NO")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COUPON_DATE", nullable = false)
    private Date couponDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COUPON_EX_START", nullable = false)
    private Date couponExStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COUPON_EX_END", nullable = false)
    private Date CouponExEnd;

    @Column(name = "COUPON_YN", nullable = false)
    private boolean couponYN;
}
