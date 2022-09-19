package com.newlearn.jpa.newlearn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "room")
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Room {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_MID", nullable = false, referencedColumnName = "MEMBER_ID")
    @JsonBackReference
    public Member roomMid;

    @Id
    @Column(name = "ROOM_NUM", nullable = false)
    private Integer roomNum;

    @Column(name = "ROOM_DEP", length = 20, nullable = false)
    private String roomDep;

    @Column(name = "ROOM_SUB", length = 20, nullable = false)
    private String roomSub;

    @Temporal(TemporalType.DATE)
    @Column(name = "ROOM_SINCE", nullable = false)
    private Date roomSince;

    @Column(name = "ROOM_RPW", length = 10, nullable = false)
    private String roomRpw;

    @OneToMany(mappedBy = "studentRnum", cascade = CascadeType.REMOVE)
    private List<Student> StudentList = new ArrayList<>();

    @OneToMany(mappedBy = "quizRnum", cascade = CascadeType.REMOVE)
    private List<Quiz> QuizList = new ArrayList<>();

    @Builder
    public Room(Member roomMid, Integer roomNum, String roomDep, String roomSub, Date roomSince,
                String roomRpw, List<Student> StudentList, List<Quiz> QuizList) {
        this.roomMid = roomMid;
        this.roomNum = roomNum;
        this.roomDep = roomDep;
        this.roomSub = roomSub;
        this.roomSince = roomSince;
        this.roomRpw = roomRpw;
        this.StudentList = StudentList;
        this.QuizList = QuizList;
    }

    public void update(String roomRpw){
        this.roomRpw = roomRpw;
    }
}
