package com.newlearn.jpa.newlearn.reqDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class AnswerUpdateDTO {
    private String answerCont;
    private String answerFile;

    @Builder
    public AnswerUpdateDTO(String answerCont, String answerFile) {
        this.answerCont = answerCont;
        this.answerFile = answerFile;
    }
}
