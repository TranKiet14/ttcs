package com.example.ttcs.TTCS.service;

import com.example.ttcs.TTCS.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(int theId);
    void save(Room room);
    void deleteById(int theId);
    List<Room> findByAddressContainingIgnoreCase(String keyword);

    List<Room> findRoomsByClientId(int clientId);
}
