package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Choice;
import com.newlearn.jpa.newlearn.entity.Quiz;
import lombok.Getter;

@Getter

public class ChoiceResDTO {
    private Quiz choiceQnum;
    private Integer choiceNum;
    private Integer choiceTotal;

    public ChoiceResDTO(Choice choice) {
        this.choiceQnum = choice.getChoiceQnum();
        this.choiceNum = choice.getChoiceNum();
        this.choiceTotal = choice.getChoiceTotal();
    }
}