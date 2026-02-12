package com.marcelo721.rewind_back_end.domain.model.entities;

import com.marcelo721.rewind_back_end.domain.model.enums.StatusAccount;
import com.marcelo721.rewind_back_end.domain.model.enums.UserType;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {

    private UUID ID;
    private String nickName;
    private String email;
    private String password;
    private String description;
    private UserType userType;
    private StatusAccount statusAccount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;


    public User(UUID ID, String nickName, String email, String password, String description,
                UserType userType, StatusAccount statusAccount, LocalDateTime createdAt,
                LocalDateTime updatedAt, String createdBy, String updatedBy) {
        this.ID = ID;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.description = description;
        this.userType = userType;
        this.statusAccount = statusAccount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
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

    public UserType getUserType() {
        return userType;
    }

    public StatusAccount getStatusAccount() {
        return statusAccount;
    }

    public void setStatusAccount(StatusAccount statusAccount) {
        this.statusAccount = statusAccount;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
