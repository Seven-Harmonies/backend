package com.voluteamhub.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "association")
public class Association {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private String email;
    private String phone;
    private String photos;
    private String userName;
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    public Association(String email, String phone, String photos, String userName, String password, String name) {
        this.email = email;
        this.phone = phone;
        this.photos = photos;
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    public Association(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
