package com.patika.kredinbizdenservice.databases;
import java.util.HashMap;

import com.patika.kredinbizdenservice.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserData {
    private HashMap<String, String> userData;

    public UserData(){
        userData = new HashMap<>();
    }

    public boolean addUser(User user){
        if(userData.containsKey(user.getEmail())){
            return false;
        }
        String encryptedPassword = encryptPassword(user.getPassword());
        userData.put(user.getEmail(), encryptedPassword);
        return true;     
    }

    private String encryptPassword(String password){
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
            StringBuilder sb = new StringBuilder();
            byte[] hashedBytes = mDigest.digest(password.getBytes());
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

}
