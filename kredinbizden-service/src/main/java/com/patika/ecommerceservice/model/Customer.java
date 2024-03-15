package com.patika.ecommerceservice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;  

public class Customer {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
    private List<Integer> orders;
    private String password;
    private LocalDate birthdate;
    
    public Customer(String name, String surname, String phoneNumber, String email, String address, String password,
            LocalDate birthdate) {
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
    public List<Integer> getOrders() {
        return orders;
    }
    public void addOrder(int orderId) {
        orders.add(orderId);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    //genelde formlarda dogum tarihi doldurulması istenir ve yas otomatik hesaplanir, burada da ayni sistem uygulanmistir
    public int getAge(){
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", address=" + address + ", orders=" + orders + "]";
    }
}
