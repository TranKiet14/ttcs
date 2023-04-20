package com.example.ttcs.TTCS.controller;

import com.example.ttcs.TTCS.entity.Client;
import com.example.ttcs.TTCS.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/register-form")
    public String showFormRegister(){
        return "clients/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("name") String name, @RequestParam("phone") String phone){
        if(clientService.findByUsername(username)!=null){
            return "redirect:/register-form";
        }
        else{
            Client client=new Client(phone,name,username,password);
            clientService.save(client);
            return "redirect:/login-form";
        }
    }
}
