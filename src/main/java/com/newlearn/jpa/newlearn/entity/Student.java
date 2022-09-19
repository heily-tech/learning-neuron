package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "student")
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Student {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_RNUM", nullable = false, referencedColumnName = "ROOM_NUM")
    @JsonBackReference
    private Room studentRnum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_NUM", nullable = false)
    private Integer studentNum;

    @Column(name = "STUDENT_TITLE", length = 45, nullable = false)
    private String studentTitle;

    @Column(name = "STUDENT_CONT", length = 1000, nullable = false)
    private String studentCont;

    @Column(name = "STUDENT_WRITER", nullable = false, unique = true)
    private Integer studentWriter;

    @Column(name = "STUDENT_FILE", length = 45)
    private String studentFile;

    @Temporal(TemporalType.DATE)
    @Column(name = "STUDENT_DATE", nullable = false)
    private Date studentDate;

    @ColumnDefault("0")
    @Column(name = "STUDENT_VIEW", nullable = false)
    private Integer studentView;

    @ColumnDefault("0")
    @Column(name = "STUDENT_ANS", nullable = false)
    private Integer studentAns;

    @OneToMany(mappedBy = "answerQnum", cascade = CascadeType.REMOVE)
    private List<Answer> AnswerList = new ArrayList<>();

    @Builder
    public Student(Room studentRnum, Integer studentNum, String studentTitle, String studentCont,
                   Integer studentWriter, String studentFile, Date studentDate, Integer studentView,
                   Integer studentAns, List<Answer> AnswerList) {
        this.studentRnum = studentRnum;
        this.studentNum = studentNum;
        this.studentTitle = studentTitle;
        this.studentCont = studentCont;
        this.studentWriter = studentWriter;
        this.studentFile = studentFile;
        this.studentDate = studentDate;
        this.studentView = studentView;
        this.studentAns = studentAns;
        this.AnswerList = AnswerList;
    }

    public void update(String studentTitle, String studentCont, String studentFile) {
        this.studentTitle = studentTitle;
        this.studentCont = studentCont;
        this.studentFile = studentFile;
    }
}
