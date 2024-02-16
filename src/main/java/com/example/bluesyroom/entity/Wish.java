package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WISH")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISH_NO", nullable = false)
    private long wishNo;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;

}
