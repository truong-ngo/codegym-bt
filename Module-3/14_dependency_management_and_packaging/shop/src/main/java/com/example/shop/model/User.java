package com.example.shop.model;

public class User {
    private Long id;
    private String role;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String url;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String phoneNumber, String address, String url) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.url = url;
    }

    public User(Long id, String role, String username, String password, String phoneNumber, String address, String url) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
