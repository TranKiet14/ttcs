package com.example.ttcs.TTCS.controller;

import com.example.ttcs.TTCS.entity.Client;
import com.example.ttcs.TTCS.service.ClientService;
import com.example.ttcs.TTCS.service.RoomService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class ViewRoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private ClientService clientService;
    @GetMapping("/phong-cua-toi")
    public String showMyRoom(HttpSession session){
        if(session.getAttribute("username")==null){
            return "redirect:/login-form";
        }
        else return "rooms/list-myroom";
    }

}
