package com.example.ttcs.TTCS.api;

import com.example.ttcs.TTCS.entity.Room;
import com.example.ttcs.TTCS.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiRoom {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms/search")
    public List<Room> searchByAddress(@RequestParam(name = "keyword", required = false) String keyword,@RequestParam(name = "minprice", required = false) Integer minPrice,
                                      @RequestParam(name = "maxprice", required = false) Integer maxPrice) {
        List<Room> list = roomService.findByAddressContainingIgnoreCase(keyword);
        if(minPrice == null && maxPrice == null) return list;
        else{
            List<Room> ds= new ArrayList<>();
            for(Room room: list){
                if(room.getPrice()>minPrice&&room.getPrice()<=maxPrice){
                    ds.add(room);
                }
            }
            return ds;
        }
    }

    @GetMapping("/rooms")
    public List<Room> searchByAddress(HttpSession session) {
        return roomService.findRoomsByClientId((Integer) session.getAttribute("id"));
    }
    @GetMapping("/rooms/info")
    public Room searchRoomById(@RequestParam(name = "id") int id){
        return roomService.findById(id);
    }
}
