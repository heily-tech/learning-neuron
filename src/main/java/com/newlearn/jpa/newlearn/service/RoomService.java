package com.newlearn.jpa.newlearn.service;

import com.newlearn.jpa.newlearn.entity.Room;
import com.newlearn.jpa.newlearn.repository.RoomRepository;
import com.newlearn.jpa.newlearn.reqDTO.RoomSaveDTO;
import com.newlearn.jpa.newlearn.reqDTO.RoomUpdateDTO;
import com.newlearn.jpa.newlearn.resDTO.RoomResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public RoomResDTO search(Integer roomNum){
        Room room = roomRepository.findByRoomNum(roomNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 방이 없습니다. 방 번호 = " + roomNum));
        return new RoomResDTO(room);
    }

    @Transactional
    public Room save(RoomSaveDTO saveDTO){
        return roomRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void update(Integer roomNum, RoomUpdateDTO updateDTO){
        Room room = roomRepository.findByRoomNum(roomNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 방이 없습니다. 방 번호 = " + roomNum));
        room.update(updateDTO.getRoomRpw());
    }

    @Transactional
    public void delete(Integer roomNum){
        Room room = roomRepository.findByRoomNum(roomNum)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 방이 없습니다. 방 번호 = " + roomNum));
        roomRepository.delete(room);
    }
}
