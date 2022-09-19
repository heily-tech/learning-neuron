package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.entity.Member;
import com.newlearn.jpa.newlearn.entity.Quiz;
import com.newlearn.jpa.newlearn.entity.Room;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor

public class QuizSaveDTO {
    private Room quizRnum;
    private Integer quizNum;
    private String quizTitle;
    private Integer quizType;
    private Date quizDate;

    @Builder
    public QuizSaveDTO(Room quizRnum, Integer quizNum, String quizTitle, Integer quizType, Date quizDate) {
        this.quizRnum = quizRnum;
        this.quizNum = quizNum;
        this.quizTitle = quizTitle;
        this.quizType = quizType;
        this.quizDate = quizDate;
    }

    public Quiz toEntity(){
        return Quiz.builder()
                .quizRnum(quizRnum)
                .quizNum(quizNum)
                .quizTitle(quizTitle)
                .quizType(quizType)
                .quizDate(quizDate)
                .build();
    }
}
