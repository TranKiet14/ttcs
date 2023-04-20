package com.example.ttcs.TTCS.dao;

import com.example.ttcs.TTCS.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByAddressContainingIgnoreCase(String keyword);
    List<Room> findRoomsByClientId(int clientId);
}
