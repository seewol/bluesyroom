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
@Table(name = "COMMENTS")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENTS_NO", nullable = false)
    private long commentsNo;

    @Column(name = "COMMENTS_CONTENT", nullable = false)
    private String commentsContent;

    @CreatedDate
    @Column(name = "COMMENTS_DATE", nullable = false)
    private LocalDateTime commentsDate;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private User user;

    @ManyToOne
    @JoinColumn(name = "QNA_NO")
    private Qna qna;
}
