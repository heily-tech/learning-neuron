package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Table(name = "quiz")
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Quiz {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUIZ_RNUM", nullable = false, referencedColumnName = "ROOM_NUM")
    @JsonBackReference
    private Room quizRnum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUIZ_NUM", nullable = false)
    private Integer quizNum;

    @Column(name = "QUIZ_TITLE", length = 45, nullable = false)
    private String quizTitle;

    @Column(name = "QUIZ_TYPE", nullable = false)
    private Integer quizType;

    @Temporal(TemporalType.DATE)
    @Column(name = "QUIZ_DATE", nullable = false)
    private Date quizDate;

    @OneToMany(mappedBy = "essayQnum", cascade = CascadeType.REMOVE)
    private List<Essay> EssayList = new ArrayList<>();

    @OneToMany(mappedBy = "choiceQnum", cascade = CascadeType.REMOVE)
    private List<Choice> ChoiceList = new ArrayList<>();

    @Builder
    public Quiz(Room quizRnum, Integer quizNum, String quizTitle, Integer quizType,
                Date quizDate, List<Essay> EssayList, List<Choice> ChoiceList) {
        this.quizRnum = quizRnum;
        this.quizNum = quizNum;
        this.quizTitle = quizTitle;
        this.quizType = quizType;
        this.quizDate = quizDate;
        this.EssayList = EssayList;
        this.ChoiceList = ChoiceList;
    }

    public void update(String quizTitle) {
        this.quizTitle = quizTitle;
    }
}
