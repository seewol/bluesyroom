package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter         // 문의에 대한 댓글
@Table(name = "COMMENTS")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENTS_NO", nullable = false)
    private long commentsNo;

    @Column(name = "COMMENTS_CONTENT", nullable = false)
    private String commentsContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COMMENTS_DATE", nullable = false)
    private Date commentsDate;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @ManyToOne
    @JoinColumn(name = "QNA_NO")
    private Qna qna;
}
