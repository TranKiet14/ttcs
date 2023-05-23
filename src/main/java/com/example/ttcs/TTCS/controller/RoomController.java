package com.example.ttcs.TTCS.controller;


import com.example.ttcs.TTCS.entity.Room;
import com.example.ttcs.TTCS.entity.RoomQueue;
import com.example.ttcs.TTCS.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class
RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/list-room")
    @ResponseBody
    public List<Room> listRoom(){
        return roomService.findAll();
    }
    @GetMapping("/home")
    public String login(){
        return "homePage";
    }

    @GetMapping("/form-room")
    public String show(HttpSession session, Model theModel){
        if(session.getAttribute("username")==null){
            return "redirect:/login-form";
        }
        else{
            RoomQueue room = new RoomQueue();
            theModel.addAttribute("tmproom",room);
            return "rooms/room-form-tmp";
        }
    }
    @GetMapping("/search")
    public String roomsearch(){
        return "rooms/list-room";
    }

    @GetMapping("/{name}")
    public String roosearchbydistrict(@PathVariable("name") String name){
        return "rooms/list-room";
    }

    @GetMapping("/thong-tin-phong")
    public String showRoom(@RequestParam(name = "id") int id){
        return "/rooms/room-info";
    }
    @GetMapping("/danhsach")
    public String showDs(Model theModel, HttpSession session){
        List<Room> list=roomService.findRoomsByClientId((Integer) session.getAttribute("id"));
        theModel.addAttribute("rooms", list);
        return "/clients/ds-phong";
    }

    @GetMapping("/delete")
    public String deleteRoom(@RequestParam("roomId") int theId){
        Room room = roomService.findById(theId);
        Path path = Paths.get("src/main/resources/static/photos/" + room.getImage());
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        roomService.deleteById(theId);
        return "redirect:/danhsach";
    }
}
