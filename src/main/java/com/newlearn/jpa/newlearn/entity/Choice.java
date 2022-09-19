package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Table(name = "choice")
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Choice {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHOICE_QNUM", nullable = false, referencedColumnName = "QUIZ_NUM")
    @JsonBackReference
    private Quiz choiceQnum;

    @Id
    @Column(name = "CHOICE_NUM", nullable = false)
    private Integer choiceNum;

    @ColumnDefault("0")
    @Column(name = "CHOICE_TOTAL", nullable = false)
    private Integer choiceTotal;

    @Builder
    public Choice(Quiz choiceQnum, Integer choiceNum, Integer choiceTotal) {
        this.choiceQnum = choiceQnum;
        this.choiceNum = choiceNum;
        this.choiceTotal = choiceTotal;
    }
}
