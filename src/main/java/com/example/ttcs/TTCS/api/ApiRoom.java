package com.example.ttcs.TTCS.api;

import com.example.ttcs.TTCS.entity.Room;
import com.example.ttcs.TTCS.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiRoom {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms/search")
    public List<Room> searchByAddress(@RequestParam(name = "keyword") String keyword,@RequestParam(name = "minPrice", required = false) Integer minPrice,
                                      @RequestParam(name = "maxPrice", required = false) Integer maxPrice) {
        return roomService.findByAddressContainingIgnoreCase(keyword);
    }

    @GetMapping("/rooms")
    public List<Room> searchByAddress(HttpSession session) {
        return roomService.findRoomsByClientId((Integer) session.getAttribute("id"));
    }
}
