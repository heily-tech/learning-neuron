package com.newlearn.jpa.newlearn.reqDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class StudentUpdateDTO {
    private String studentTitle;
    private String studentCont;
    private String studentFile;

    @Builder
    public StudentUpdateDTO(String studentTitle, String studentCont, String studentFile) {
        this.studentTitle = studentTitle;
        this.studentCont = studentCont;
        this.studentFile = studentFile;
    }
}
