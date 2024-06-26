package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "ORDER_TABLE")
public class Order {

    @Id
    @Column(name = "ORDER_NO", nullable = false)
    private long orderNo;

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

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

    @Column(name = "TRACKING_NUMBER")
    private String trackingNumber;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

}
