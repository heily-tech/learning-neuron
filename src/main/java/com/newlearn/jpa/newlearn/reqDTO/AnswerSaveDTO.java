package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.entity.Answer;
import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.entity.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class AnswerSaveDTO {
    private Student answerQnum;
    private Integer answerNum;
    private String answerCont;
    private String answerFile;

    @Builder
    public AnswerSaveDTO(Student answerQnum, Integer answerNum, String answerCont, String answerFile) {
        this.answerQnum = answerQnum;
        this.answerNum = answerNum;
        this.answerCont = answerCont;
        this.answerFile = answerFile;
    }

    public Answer toEntity(){
        return Answer.builder()
                .answerQnum(answerQnum)
                .answerNum(answerNum)
                .answerCont(answerCont)
                .answerFile(answerFile)
                .build();
    }
}
