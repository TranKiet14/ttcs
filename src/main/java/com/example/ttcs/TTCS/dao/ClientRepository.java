package com.example.ttcs.TTCS.dao;

import com.example.ttcs.TTCS.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByUsername(String username);
}
