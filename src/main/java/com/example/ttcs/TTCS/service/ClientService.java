package com.example.ttcs.TTCS.service;

import com.example.ttcs.TTCS.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(int theId);
    void save(Client client);
    void deleteById(int theId);

    Client findByUsername(String username);
}
