package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter       // 문의
@Table(name = "QNA")
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QNA_NO", nullable = false)
    private long qnaNo;

    @Column(name = "QNA_TITLE", nullable = false)
    private String qnaTitle;

    @Column(name = "QNA_CONTENT", nullable = false)
    private String qnaContent;

    @ManyToOne
    @JoinColumn(name="USER_NO")
    private User user;

    @OneToOne
    @JoinColumn(name="QNA_CATEGORY_NO")
    private QnaCategory qnaCategory;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "QNA_DATE", nullable = false)
    private Date qnaDate;
}
