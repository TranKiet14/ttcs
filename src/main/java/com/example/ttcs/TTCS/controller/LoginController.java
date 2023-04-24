package com.example.ttcs.TTCS.controller;

import com.example.ttcs.TTCS.entity.Client;
import com.example.ttcs.TTCS.service.ClientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/login-form")
    public String showFormLogin(){
        return "clients/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        // Kiểm tra thông tin đăng nhập ở đây
        Client client = clientService.findByUsername(username);
        if(client==null){
            return "redirect:/login-form";
        }
        else{
            if(!client.getPassword().equals(password)){
                return "redirect:/login-form";
            }
        }
        // Lưu thông tin đăng nhập vào session để sử dụng ở các request sau
        session.setAttribute("username", username);
        session.setAttribute("id", client.getId());
        return "redirect:/home";
    }
}
