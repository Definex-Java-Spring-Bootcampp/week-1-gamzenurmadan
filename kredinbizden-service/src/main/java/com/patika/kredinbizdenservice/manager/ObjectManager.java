package com.patika.kredinbizdenservice.manager;

import com.patika.kredinbizdenservice.databases.UserData;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ObjectManager {
    private static ObjectManager instance;
    private List<Bank> banks;
    private List<Campaign> campaigns;
    private List<Application> applications;
    private List<User> users;
    private UserData loggedUsers;

    private ObjectManager(){
        banks = new ArrayList<>();
        campaigns = new ArrayList<>();
        applications = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static ObjectManager getInstance(){
        if (instance == null) {
            instance = new ObjectManager();
        }
        return instance;
    }

    public User createUser(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive){
        User user = new User(name, surname, birthDate, email, password, phoneNumber, isActive);
        if(loggedUsers.addUser(user)){
            users.add(user);
        }else{
            System.out.println("This user is created before!");
        }
        return user;
    }

    public Bank createBank(String name){
        Bank bank = new Bank(name);
        banks.add(bank);
        return bank;
    }

    public Campaign createCampaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector){
        Campaign campaign = new Campaign(title, content, dueDate, createDate, updateDate, sector);
        campaigns.add(campaign);
        return campaign;
    }

    public Application createApplication(Product product, User user, LocalDateTime localDateTime){
        Application application = new Application(product, user, localDateTime);
        applications.add(application);
        user.addApplication(application);
        return application;
    }

    public List<User> getUsers(){
        return users;
    }

    public List<Campaign> getCampaigns(){
        return campaigns;
    }

    public List<Bank> getBanks(){
        return banks;
    }

    public List<Application> getApplications(){
        return applications;
    }
}
