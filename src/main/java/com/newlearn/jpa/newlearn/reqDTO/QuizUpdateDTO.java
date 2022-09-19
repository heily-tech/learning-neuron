package com.newlearn.jpa.newlearn.reqDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class QuizUpdateDTO {
    private String quizTitle;

    @Builder
    public QuizUpdateDTO(String quizTitle) {
        this.quizTitle = quizTitle;
    }
}
