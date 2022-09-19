package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.entity.Quiz;
import lombok.Getter;

@Getter

public class EssayResDTO {
    private Quiz essayQnum;
    private Integer essayNum;
    private String essayCont;
    private Integer essayGood;

    public EssayResDTO(Essay essay) {
        this.essayQnum = essay.getEssayQnum();
        this.essayNum = essay.getEssayNum();
        this.essayCont = essay.getEssayCont();
        this.essayGood = essay.getEssayGood();
    }
}
