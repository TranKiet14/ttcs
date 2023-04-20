package com.example.ttcs.TTCS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "dientich")
    private int dientich;
    @Column(name = "type")
    private String type;
    @Column(name = "trangthai")
    private String trangthai;
    @Column(name = "noithat")
    private String noithat;
    @Column(name = "dichvu")
    private String dichvu;
    @Column(name = "price")
    private float price;
    @Column(name = "image")
    private String image;
    @Column(name = "link")
    private String linkImages;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    public Room() {
    }

    public Room(String address, int dientich, String type, String trangthai, String noithat, String dichvu, float price, String image, String linkImages) {
        this.address = address;
        this.dientich = dientich;
        this.type = type;
        this.trangthai = trangthai;
        this.noithat = noithat;
        this.dichvu = dichvu;
        this.price = price;
        this.image = image;
        this.linkImages = linkImages;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDientich() {
        return dientich;
    }

    public void setDientich(int dientich) {
        this.dientich = dientich;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getNoithat() {
        return noithat;
    }

    public void setNoithat(String noithat) {
        this.noithat = noithat;
    }

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkImages() {
        return linkImages;
    }

    public void setLinkImages(String linkImages) {
        this.linkImages = linkImages;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", dientich=" + dientich +
                ", type='" + type + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", noithat='" + noithat + '\'' +
                ", dichvu='" + dichvu + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", linkImages='" + linkImages + '\'' +
                '}';
    }
}
