package com.example.ttcs.TTCS.controller;


import com.example.ttcs.TTCS.entity.Room;
import com.example.ttcs.TTCS.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class RoomController {
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
    public String show(HttpSession session){
        if(session.getAttribute("username")==null){
            return "redirect:/login-form";
        }
        else{
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
}
