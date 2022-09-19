package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.entity.Member;
import com.newlearn.jpa.newlearn.entity.Room;
import com.newlearn.jpa.newlearn.entity.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class StudentSaveDTO {
    private Room studentRnum;
    private Integer studentNum;
    private String studentTitle;
    private String studentCont;
    private Integer studentWriter;
    private String studentFile;
    private Date studentDate;
    private Integer studentView;
    private Integer studentAns;

    @Builder
    public StudentSaveDTO(Room studentRnum, Integer studentNum, String studentTitle, String studentCont, Integer studentWriter,
                          String studentFile, Date studentDate, Integer studentView, Integer studentAns) {
        this.studentRnum = studentRnum;
        this.studentNum = studentNum;
        this.studentTitle = studentTitle;
        this.studentCont = studentCont;
        this.studentWriter = studentWriter;
        this.studentFile = studentFile;
        this.studentDate = studentDate;
        this.studentView = studentView;
        this.studentAns = studentAns;
    }

    public Student toEntity(){
        return Student.builder()
                .studentRnum(studentRnum)
                .studentNum(studentNum)
                .studentTitle(studentTitle)
                .studentCont(studentCont)
                .studentWriter(studentWriter)
                .studentFile(studentFile)
                .studentDate(studentDate)
                .studentAns(studentAns)
                .build();
    }
}
