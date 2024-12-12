package com.example.sbb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    //질문과 답변을 연결해주는 어노테이션
    @ManyToOne
    private Question question;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
