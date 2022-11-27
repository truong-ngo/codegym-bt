package com.example.customers;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String address;
    private String URL;

    public Customer(String name, String dateOfBirth, String address, String URL) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
