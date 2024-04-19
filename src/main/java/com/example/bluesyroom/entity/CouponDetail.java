package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
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

    @CreatedDate
    @Column(name = "COUPON_DATE", nullable = false)
    private LocalDateTime couponDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COUPON_EX_START", nullable = false)
    private Date couponExStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COUPON_EX_END", nullable = false)
    private Date CouponExEnd;

    @Column(name = "IS_USED", nullable = false)
    private boolean couponYN;
}
