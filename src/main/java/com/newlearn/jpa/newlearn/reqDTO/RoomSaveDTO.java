package com.newlearn.jpa.newlearn.reqDTO;

import com.newlearn.jpa.newlearn.entity.Member;

import com.newlearn.jpa.newlearn.entity.Room;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor

public class RoomSaveDTO {
    private Member roomMid;
    private Integer roomNum;
    private String roomDep;
    private String roomSub;
    private Date roomSince;
    private String roomRpw;

    @Builder
    public RoomSaveDTO(Member roomMid, Integer roomNum, String roomDep, String roomSub, Date roomSince, String roomRpw) {
        this.roomMid = roomMid;
        this.roomNum = roomNum;
        this.roomDep = roomDep;
        this.roomSub = roomSub;
        this.roomSince = roomSince;
        this.roomRpw = roomRpw;
    }

    public Room toEntity(){
        return Room.builder()
                .roomMid(roomMid)
                .roomNum(roomNum)
                .roomDep(roomDep)
                .roomSub(roomSub)
                .roomSince(roomSince)
                .roomRpw(roomRpw)
                .build();
    }
}
