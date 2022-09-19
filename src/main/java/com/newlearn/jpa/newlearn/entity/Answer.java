package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Table(name = "answer")
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Answer {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_QNUM", nullable = false, referencedColumnName = "STUDENT_NUM")
    @JsonBackReference
    private Student answerQnum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_NUM", nullable = false)
    private Integer answerNum;

    @Column(name = "ANSWER_CONT", length = 1000, nullable = false)
    private String answerCont;

    @Column(name = "ANSWER_FILE", length = 45)
    private String answerFile;

    @Builder
    public Answer(Student answerQnum, Integer answerNum, String answerCont, String answerFile) {
        this.answerQnum = answerQnum;
        this.answerNum = answerNum;
        this.answerCont = answerCont;
        this.answerFile = answerFile;
    }

    public void update(String answerCont, String answerFile) {
        this.answerCont = answerCont;
        this.answerFile = answerFile;
    }
}
