package com.newlearn.jpa.newlearn.resDTO;

import com.newlearn.jpa.newlearn.entity.Member;
import com.newlearn.jpa.newlearn.entity.Room;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter

public class MemberResDTO {
    private String memberId;
    private String memberPasswd;
    private String memberName;
    private Integer memberQues;
    private String memberAns;
    private String memberEmail;
    private Date memberSince;
    private List<Room> RoomList;

    public MemberResDTO(Member member){
        this.memberId = member.getMemberId();
        this.memberPasswd = member.getMemberPasswd();
        this.memberName = member.getMemberName();
        this.memberQues = member.getMemberQues();
        this.memberAns = member.getMemberAns();
        this.memberEmail = member.getMemberEmail();
        this.memberSince = member.getMemberSince();
        this.RoomList = member.getRoomList();
    }
}
