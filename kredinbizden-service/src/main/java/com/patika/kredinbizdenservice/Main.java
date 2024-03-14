package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.loggers.ConsoleLogger;
import com.patika.kredinbizdenservice.model.*;

import java.util.HashSet;

import com.patika.kredinbizdenservice.databases.*;

public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = ConsoleLogger.getInstance(); //Singleton Design pattern is used.
        UserData userData = new UserData();
        HashSet<User> users = new HashSet<>();
        
        User cemDirmn = new User("Cem", "Dirman", "cemdrman@gmail.com", "newPassword", "+901232366589", true);
        if(userData.addUser(cemDirmn)){
            consoleLogger.log(cemDirmn.getName()+ " "+ cemDirmn.getSurname()+ " is added succesfully");
            users.add(cemDirmn);
        }else{
            consoleLogger.log(cemDirmn.getName()+ cemDirmn.getSurname()+ " cannot be added: email should be unique");
        }

        

        
    }
}