package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.entity.Choice;
import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.entity.Quiz;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ChoiceSaveDTO {
    private Quiz choiceQnum;
    private Integer choiceNum;
    private Integer choiceTotal;

    @Builder
    public ChoiceSaveDTO(Quiz choiceQnum, Integer choiceNum, Integer choiceTotal) {
        this.choiceQnum = choiceQnum;
        this.choiceNum = choiceNum;
        this.choiceTotal = choiceTotal;
    }

    public Choice toEntity(){
        return Choice.builder()
                .choiceQnum(choiceQnum)
                .choiceNum(choiceNum)
                .choiceTotal(choiceTotal)
                .build();
    }
}
