package com.example.bluesyroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
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

    /* @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "QNA_DATE", nullable = false)
    private Date qnaDate; */

    @CreatedDate
    @Column(name = "QNA_DATE", nullable = false)
    private LocalDateTime qnaDate;

    @OneToMany(mappedBy = "qna")
    private List<Comments> commentsList = new ArrayList<>();
}
