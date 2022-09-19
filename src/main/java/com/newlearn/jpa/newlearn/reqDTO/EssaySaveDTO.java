package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.entity.Essay;
import com.newlearn.jpa.newlearn.entity.Quiz;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class EssaySaveDTO {


    private Quiz essayQnum;
    private Integer essayNum;
    private String essayCont;
    private Integer essayGood;

    @Builder
    public EssaySaveDTO(Quiz essayQnum, Integer essayNum, String essayCont, Integer essayGood) {
        this.essayQnum = essayQnum;
        this.essayNum = essayNum;
        this.essayCont = essayCont;
        this.essayGood = essayGood;
    }

    public Essay toEntity(){
        return Essay.builder()
                .essayQnum(essayQnum)
                .essayNum(essayNum)
                .essayCont(essayCont)
                .essayGood(essayGood)
                .build();
    }
}
