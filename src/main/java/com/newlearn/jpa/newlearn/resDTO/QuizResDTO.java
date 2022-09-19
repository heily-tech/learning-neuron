package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Choice;
import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.entity.Quiz;
import com.newlearn.jpa.newlearn.entity.Room;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter

public class QuizResDTO {
    private Room quizRnum;
    private Integer quizNum;
    private String quizTitle;
    private Integer quizType;
    private Date quizDate;
    private List<Essay> EssayList;
    private List<Choice> ChoiceList;

    public QuizResDTO(Quiz quiz) {
        this.quizRnum = quiz.getQuizRnum();
        this.quizNum = quiz.getQuizNum();
        this.quizTitle = quiz.getQuizTitle();
        this.quizType = quiz.getQuizType();
        this.quizDate = quiz.getQuizDate();
        this.EssayList = quiz.getEssayList();
        this.ChoiceList = quiz.getChoiceList();
    }
}
