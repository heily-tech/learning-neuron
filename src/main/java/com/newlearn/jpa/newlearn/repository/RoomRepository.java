package com.newlearn.jpa.newlearn.repository;

import com.newlearn.jpa.newlearn.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByRoomNum(Integer roomNum);
}
