package com.example.ttcs.TTCS.service;

import com.example.ttcs.TTCS.dao.RoomRepository;
import com.example.ttcs.TTCS.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(int theId) {
        Optional<Room> rs=roomRepository.findById(theId);
        Room room=null;
        if(rs.isPresent()){
            room=rs.get();
        }
        else{
            room=null;
        }
        return room;
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteById(int theId) {
        roomRepository.deleteById(theId);
    }

    @Override
    public List<Room> findByAddressContainingIgnoreCase(String keyword) {
        return roomRepository.findByAddressContainingIgnoreCase(keyword);
    }

    @Override
    public List<Room> findRoomsByClientId(int clientId) {
        return roomRepository.findRoomsByClientId(clientId);
    }
}
