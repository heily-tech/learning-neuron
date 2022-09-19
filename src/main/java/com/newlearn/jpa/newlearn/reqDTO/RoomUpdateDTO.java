package com.newlearn.jpa.newlearn.reqDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class RoomUpdateDTO {
    private String roomRpw;

    @Builder
    public RoomUpdateDTO(String roomRpw) {
        this.roomRpw = roomRpw;
    }
}
