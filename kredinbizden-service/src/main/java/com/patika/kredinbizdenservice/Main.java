package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.loggers.ConsoleLogger;
import com.patika.kredinbizdenservice.manager.CreditCardFactory;
import com.patika.kredinbizdenservice.manager.IProductFactory;
import com.patika.kredinbizdenservice.manager.LoanFactory;
import com.patika.kredinbizdenservice.manager.ObjectManager;
import com.patika.kredinbizdenservice.model.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = ConsoleLogger.getInstance(); //Singleton Design pattern is used.
        ObjectManager objectManager = ObjectManager.getInstance(); //Singleton Design pattern is used.
        Main main = new Main();

        IProductFactory<Loan> houseLoanFactory = new LoanFactory(LoanType.KONUT_KREDISI);//Factory Design pattern is used.
        IProductFactory<Loan> consumerLoanFactory = new LoanFactory(LoanType.IHTIYAC_KREDISI);
        IProductFactory<Loan> vehicleLoanFactory = new LoanFactory(LoanType.ARAC_KREDISI);

        Loan houseLoan1 = (Loan) houseLoanFactory.createProduct(new BigDecimal("200000.00"), 240, 0.04);
        Loan houseLoan2 = (Loan) houseLoanFactory.createProduct(new BigDecimal("200000.00"), 240, 0.04);

        Loan consumerLoan1 = (Loan) consumerLoanFactory.createProduct(new BigDecimal("5000.00"), 12, 0.10);
        Loan consumerLoan2 = (Loan) consumerLoanFactory.createProduct(new BigDecimal("10000.00"), 12, 0.70);

        Loan vehicleLoan1 = (Loan) vehicleLoanFactory.createProduct(new BigDecimal("25000.00"), 60, 0.08);
        Loan vehicleLoan2 = (Loan) vehicleLoanFactory.createProduct(new BigDecimal("29000.00"), 60, 0.1);

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

        IProductFactory<CreditCard> creditCardFactory = new CreditCardFactory(); //Factory Design pattern is used.

        CreditCard creditCard1 = (CreditCard) creditCardFactory.createProduct(new BigDecimal("50.00"));
        CreditCard creditCard2 = (CreditCard) creditCardFactory.createProduct(new BigDecimal("30.00"));

        creditCard1.addCampaign(campaign5);
        creditCard1.addCampaign(campaign3);
        creditCard2.addCampaign(campaign1);
        creditCard2.addCampaign(campaign2);
        creditCard2.addCampaign(campaign4);

        Application app1 = objectManager.createApplication(houseLoan1, user0, LocalDateTime.now());
        Application app2 = objectManager.createApplication(houseLoan2, user2, LocalDateTime.now());
        Application app3 = objectManager.createApplication(consumerLoan1, user1, LocalDateTime.now());
        Application app4 = objectManager.createApplication(consumerLoan2, user0, LocalDateTime.now());
        Application app5 = objectManager.createApplication(vehicleLoan1, user0, LocalDateTime.now());
        Application app6 = objectManager.createApplication(vehicleLoan2, user0, LocalDateTime.now());

        User mostApplied = main.findMostActiveApplicant(objectManager.getUsers());
        consoleLogger.log("En cok basvuru yapan kullanici: "+ mostApplied.getName() + " "+ mostApplied.getSurname());

        List<Application> lastMonthApplications = main.listApplicationsLastMonth(objectManager.getApplications());
        consoleLogger.log("Son 1 Aylik yapilan basvurular: "+ lastMonthApplications);

        List<CreditCard> sortedCreditCards = main.CreditCardOffersByCampaignCount(creditCardFactory.getProducts());
        consoleLogger.log("Kampanya sayisi en coktan en aza olacak sekilde siralanan kredi kartlari: "+ sortedCreditCards);

       List<Application> specifiedUserApplications = main.getUserApplicationsByEmail(objectManager.getApplications(), "cemdrman@gmail.com");
       consoleLogger.log("cemdrman@gmail.com mail adresine sahip kullanicinin butun basvurulari: "+ specifiedUserApplications);
    }

    public User findMostActiveApplicant(List<User> users) {
        User mostAppliedUser = null;
        int maxApplications = 0;
        for (User user : users) {
            int numApplications = user.getApplicationList().size();
            if (numApplications > maxApplications) {
                maxApplications = numApplications;
                mostAppliedUser = user;
            }
        }
        return mostAppliedUser;
    }

    public List<Application> listApplicationsLastMonth(List<Application> applications) {
        List<Application> lastMonthApplications = new ArrayList<>();
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
    
        for (Application application : applications) {
            if (application.getLocalDateTime().toLocalDate().isAfter(oneMonthAgo)) {
                lastMonthApplications.add(application);
            }
        }
    
        return lastMonthApplications;
    }

    public List<CreditCard> CreditCardOffersByCampaignCount(List<CreditCard> creditCards) {
    creditCards.sort(Comparator.comparingInt(card -> card.getCampaignList().size()));
    Collections.reverse(creditCards);
    return creditCards;
    }
    
    public List<Application> getUserApplicationsByEmail(List<Application> applications, String email) {
        List<Application> userApplications = new ArrayList<>();
        for (Application application : applications) {
            if (application.getUser().getEmail().equals(email)) {
                userApplications.add(application);
            }
        }
        return userApplications;
    } 
}