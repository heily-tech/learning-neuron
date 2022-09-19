package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Member;
import com.newlearn.jpa.newlearn.entity.Quiz;
import com.newlearn.jpa.newlearn.entity.Room;
import com.newlearn.jpa.newlearn.entity.Student;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter

public class RoomResDTO {
    private Member roomMid;
    private Integer roomNum;
    private String roomDep;
    private String roomSub;
    private Date roomSince;
    private String roomRpw;
    private List<Student> StudentList;
    private List<Quiz> QuizList;

    public RoomResDTO(Room room) {
        this.roomMid = room.getRoomMid();
        this.roomNum = room.getRoomNum();
        this.roomDep = room.getRoomDep();
        this.roomSub = room.getRoomSub();
        this.roomSince = room.getRoomSince();
        this.roomRpw = room.getRoomRpw();
        this.StudentList = room.getStudentList();
        this.QuizList = room.getQuizList();
    }
}
