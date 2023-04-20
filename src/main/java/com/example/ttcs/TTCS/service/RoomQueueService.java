package com.example.ttcs.TTCS.service;
import com.example.ttcs.TTCS.entity.RoomQueue;

import java.util.List;

public interface RoomQueueService {
    List<RoomQueue> findAll();
    RoomQueue findById(int theId);
    void save(RoomQueue room);
    void deleteById(int theId);
}
