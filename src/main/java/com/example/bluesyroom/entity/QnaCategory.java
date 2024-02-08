package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "QNA_CATEGORY")
public class QnaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QNA_CATEGORY_NO", nullable = false)
    private long qnaCategoryNo;

    @Column(name = "QNA_CATEGORY_NAME", nullable = false)
    private String qnaCategoryName;

}
