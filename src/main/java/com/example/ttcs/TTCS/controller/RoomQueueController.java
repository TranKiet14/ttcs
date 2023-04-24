package com.example.ttcs.TTCS.controller;

import com.example.ttcs.TTCS.entity.Client;
import com.example.ttcs.TTCS.entity.RoomQueue;
import com.example.ttcs.TTCS.service.ClientService;
import com.example.ttcs.TTCS.service.RoomQueueService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class RoomQueueController {
    @Autowired
    private RoomQueueService roomQueueService;
    @Autowired
    private ClientService clientService;
    @PostMapping("/xet-duyet")
    public String duyet(@ModelAttribute("tmproom") RoomQueue room, @RequestParam("fileImage") MultipartFile file, HttpSession session){
        String fileName = file.getOriginalFilename();
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src/main/resources/static/photos/" + fileName);
            Files.write(path, bytes);
            room.setImage(fileName);
            Client client = clientService.findById((Integer) session.getAttribute("id"));
            room.setClient(client);
            roomQueueService.save(room);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

}
