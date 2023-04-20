package com.example.ttcs.TTCS.service;

import com.example.ttcs.TTCS.dao.RoomQueueRepository;
import com.example.ttcs.TTCS.entity.RoomQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomQueueServiceImpl implements RoomQueueService{
    @Autowired
    private RoomQueueRepository roomQueueRepository;
    @Override
    public List<RoomQueue> findAll() {
        return roomQueueRepository.findAll();
    }

    @Override
    public RoomQueue findById(int theId) {
        Optional<RoomQueue> rs=roomQueueRepository.findById(theId);
        RoomQueue room=null;
        if(rs.isPresent()){
            room=rs.get();
        }
        else{
            room=null;
        }
        return room;
    }

    @Override
    public void save(RoomQueue room) {
        roomQueueRepository.save(room);
    }

    @Override
    public void deleteById(int theId) {
        roomQueueRepository.deleteById(theId);
    }
}
