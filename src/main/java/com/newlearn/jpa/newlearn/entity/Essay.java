package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Table(name = "essay")
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Essay {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESSAY_QNUM", nullable = false, referencedColumnName = "QUIZ_NUM")
    @JsonBackReference
    private Quiz essayQnum;

    @Id
    @Column(name = "ESSAY_NUM", nullable = false)
    private Integer essayNum;

    @Column(name = "ESSAY_CONT", length = 200, nullable = false)
    private String essayCont;

    @ColumnDefault("0")
    @Column(name = "ESSAY_GOOD", nullable = false)
    private Integer essayGood;

    @Builder
    public Essay(Quiz essayQnum, Integer essayNum, String essayCont, Integer essayGood) {
        this.essayQnum = essayQnum;
        this.essayNum = essayNum;
        this.essayCont = essayCont;
        this.essayGood = essayGood;
    }
}
