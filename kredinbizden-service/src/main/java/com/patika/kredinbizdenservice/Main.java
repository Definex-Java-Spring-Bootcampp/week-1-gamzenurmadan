package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.loggers.ConsoleLogger;
import com.patika.kredinbizdenservice.manager.IProductFactory;
import com.patika.kredinbizdenservice.manager.LoanFactory;
import com.patika.kredinbizdenservice.manager.ObjectManager;
import com.patika.kredinbizdenservice.model.*;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = ConsoleLogger.getInstance(); //Singleton Design pattern is used.
        ObjectManager objectManager = ObjectManager.getInstance(); //Singleton Design pattern is used.

        IProductFactory houseLoanFactory = new LoanFactory(new BigDecimal("200000.00"), 240, 0.04, LoanType.KONUT_KREDISI);
        IProductFactory consumerLoanFactory = new LoanFactory(new BigDecimal("5000.00"), 12, 0.10, LoanType.IHTIYAC_KREDISI);
        IProductFactory vehicleLoanFactory = new LoanFactory(new BigDecimal("25000.00"), 60, 0.08, LoanType.ARAC_KREDISI);

        User user0 = objectManager.createUser("Cem", "Dirman", LocalDate.of(1997, 5, 15),"cemdrman@gmail.com", "newPassword", "+901232366589", true);
        User user1 = objectManager.createUser("John", "Doe", LocalDate.of(1990, 5, 15), "john@example.com", "password123", "+1234567890", true);
        User user2 = objectManager.createUser("Alice", "Smith", LocalDate.of(1985, 9, 20), "alice@example.com", "password456", "+1987654321", true);
        User user3 = objectManager.createUser("Bob", "Johnson", LocalDate.of(1988, 3, 10), "bob@example.com", "password789", "+1112223334", true);
        User user4 = objectManager.createUser("Emily", "Brown", LocalDate.of(1995, 12, 5), "emily@example.com", "passwordabc", "+4445556667", true);
        User user5 = objectManager.createUser("Michael", "Wilson", LocalDate.of(1978, 7, 25), "michael@example.com", "passwordxyz", "+7778889990", true);

        Bank bank1 = objectManager.createBank("Bank of America");
        Bank bank2 = objectManager.createBank("JP Morgan Chase");
        Bank bank3 = objectManager.createBank("Wells Fargo");
        Bank bank4 = objectManager.createBank("Citibank");
        Bank bank5 = objectManager.createBank("Goldman Sachs");

        Campaign campaign1 = objectManager.createCampaign("Summer Sale", "Big discounts on selected items", LocalDate.of(2024, 6, 30), LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 1), SectorType.MARKET);
        Campaign campaign2 = objectManager.createCampaign("New Year Special", "Exclusive deals for the new year", LocalDate.of(2025, 1, 5), LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 15), SectorType.MARKET);
        Campaign campaign3 = objectManager.createCampaign("Tech Expo", "Showcasing latest technology innovations", LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 1), SectorType.OTHERS);
        Campaign campaign4 = objectManager.createCampaign("Health Awareness", "Promoting healthy lifestyle choices", LocalDate.of(2024, 7, 31), LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 1), SectorType.OTHERS);
        Campaign campaign5 = objectManager.createCampaign("Financial Literacy", "Educating about financial management", LocalDate.of(2024, 8, 15), LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 1), SectorType.OTHERS);





        

        
    }
}