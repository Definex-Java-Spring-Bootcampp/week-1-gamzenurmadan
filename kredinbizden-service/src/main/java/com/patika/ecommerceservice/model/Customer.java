package com.patika.ecommerceservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
    private List<Order> orders;
    private String password;
    private Date birthdate;
    
    public Customer(String name, String surname, String phoneNumber, String email, String address, String password,
            Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.birthdate = birthdate;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    @Override
    public String toString() {
        return "Customer [name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", address=" + address + ", orders=" + orders + "]";
    }
}
