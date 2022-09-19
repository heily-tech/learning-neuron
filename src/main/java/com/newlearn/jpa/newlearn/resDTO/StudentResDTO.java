package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Answer;
import com.newlearn.jpa.newlearn.entity.Room;
import com.newlearn.jpa.newlearn.entity.Student;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter

public class StudentResDTO {
    private Room studentRnum;
    private Integer studentNum;
    private String studentTitle;
    private String studentCont;
    private Integer studentWriter;
    private String studentFile;
    private Date studentDate;
    private Integer studentView;
    private Integer studentAns;
    private List<Answer> AnswerList;

    public StudentResDTO(Student student) {
        this.studentRnum = student.getStudentRnum();
        this.studentNum = student.getStudentNum();
        this.studentTitle = student.getStudentTitle();
        this.studentCont = student.getStudentCont();
        this.studentWriter = student.getStudentWriter();
        this.studentFile = student.getStudentFile();
        this.studentDate = student.getStudentDate();
        this.studentView = student.getStudentView();
        this.studentAns = student.getStudentAns();
        this.AnswerList = student.getAnswerList();
    }
}
