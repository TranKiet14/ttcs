package com.example.ttcs.TTCS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="phone")
    private String phone;
    @Column(name="name")
    private String name;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<RoomQueue> roomQueues;

    public Client() {
    }

    public Client(String phone, String name, String username, String password) {
        this.phone = phone;
        this.name = name;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
