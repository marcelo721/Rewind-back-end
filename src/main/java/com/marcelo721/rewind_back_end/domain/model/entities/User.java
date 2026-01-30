package com.marcelo721.rewind_back_end.domain.model.entities;

import java.util.UUID;

public class User {

    private UUID ID;
    private String nickName;
    private String email;
    private String password;
    private String description;

    public User(UUID ID, String nickName, String email, String password, String description) {
        this.ID = ID;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public User() {
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
