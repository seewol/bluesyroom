package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_NO")
    private long addressNo;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @Column(name = "ADDRESS_NAME")
    private String addressName;

    @Column(name = "RECEIVER")
    private String receiver;

    @Column(name = "ZONECODE")
    private String zonecode;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ADDRESS_DETAIL")
    private String addressDetail;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "IS_DEFAULT")
    private boolean isDefault;
}

