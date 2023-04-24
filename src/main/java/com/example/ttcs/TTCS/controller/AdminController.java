package com.example.ttcs.TTCS.controller;

import com.example.ttcs.TTCS.entity.Client;
import com.example.ttcs.TTCS.entity.Room;
import com.example.ttcs.TTCS.entity.RoomQueue;
import com.example.ttcs.TTCS.service.ClientService;
import com.example.ttcs.TTCS.service.RoomQueueService;
import com.example.ttcs.TTCS.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RoomQueueService roomQueueService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ClientService clientService;
    @GetMapping("/ds-duyet")
    public String showDsDuyet(Model theModel){
        List<RoomQueue> list=roomQueueService.findAll();
        theModel.addAttribute("rooms", list);
        return "/admin/ds-duyet";
    }
    @GetMapping
    public String index(){
        return "redirect:/admin/ds-client";
    }
    @GetMapping("/ds-client")
    public String showDsClient(Model theModel){
        List<Client> list=clientService.findAll();
        theModel.addAttribute("clients", list);
        return "/admin/ds-client";
    }
    @GetMapping("/thong-tin")
    public String showThongtin(@RequestParam("roomId") int id, Model theModel){
        RoomQueue room = roomQueueService.findById(id);
        theModel.addAttribute("room",room);
        return "/admin/room-info";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("clientId") int theId){
        clientService.deleteById(theId);
        return "redirect:/admin/ds-client";
    }
    @GetMapping("/deleteroom")
    public String deleteRoom(@RequestParam("roomId") int theId){
        RoomQueue room = roomQueueService.findById(theId);
        Path path = Paths.get("src/main/resources/static/photos/" + room.getImage());
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        roomQueueService.deleteById(theId);
        return "redirect:/admin/ds-duyet";
    }

    @GetMapping("/save")
    public String save(@RequestParam("roomId") int theId){
        RoomQueue roomQueue = roomQueueService.findById(theId);
        Room room = new Room();
        room.setAddress(roomQueue.getAddress());
        room.setDichvu(roomQueue.getDichvu());
        room.setDientich(roomQueue.getDientich());
        room.setImage(roomQueue.getImage());
        room.setLinkImages(roomQueue.getLinkImages());
        room.setPrice(roomQueue.getPrice());
        room.setNoithat(roomQueue.getNoithat());
        room.setTrangthai(roomQueue.getTrangthai());
        room.setType(roomQueue.getType());
        room.setClient(roomQueue.getClient());
        roomService.save(room);
        roomQueueService.deleteById(theId);
        return "redirect:/admin/ds-duyet";
    }
}
