package com.example.farmmartmobile.model;

import java.time.LocalDateTime;

public class User {
    private int userId;
    private String profileImgUrl;
    private UserType type;
    private String firstName, lastName, email, phoneNumber, password;
    private LocalDateTime createdTime, updatedTime;

    public User(int userId, String profileImgUrl, UserType type, String firstName, String lastName, String email, String phoneNumber, String password, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.userId = userId;
        this.type = type;
        this.profileImgUrl = profileImgUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setUserId(int id) {
        this.userId = id;
    }
    public UserType getType() {
        return type;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }
}
