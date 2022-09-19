package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Answer;
import com.newlearn.jpa.newlearn.entity.Student;
import lombok.Getter;

@Getter

public class AnswerResDTO {
    private Student answerQnum;
    private Integer answerNum;
    private String answerCont;
    private String answerFile;

    public AnswerResDTO(Answer answer) {
        this.answerQnum = answer.getAnswerQnum();
        this.answerNum = answer.getAnswerNum();
        this.answerCont = answer.getAnswerCont();
        this.answerFile = answer.getAnswerFile();
    }
}
