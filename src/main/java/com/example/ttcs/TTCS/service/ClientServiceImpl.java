package com.example.ttcs.TTCS.service;

import com.example.ttcs.TTCS.dao.ClientRepository;
import com.example.ttcs.TTCS.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int theId) {
        Optional<Client> rs=clientRepository.findById(theId);
        Client client=null;
        if(rs.isPresent()){
            client=rs.get();
        }
        else{
            client=null;
        }
        return client;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteById(int theId) {
        clientRepository.deleteById(theId);
    }

    @Override
    public Client findByUsername(String username) {
        Optional<Client> rs= Optional.ofNullable(clientRepository.findByUsername(username));
        Client client=null;
        if(rs.isPresent()){
            client=rs.get();
        }
        else{
            client=null;
        }
        return client;
    }
}
