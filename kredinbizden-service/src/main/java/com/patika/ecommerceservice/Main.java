package com.patika.ecommerceservice;

import com.patika.ecommerceservice.enums.Category;
import com.patika.ecommerceservice.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();

        Customer customer1 = new Customer("John", "Doe", "123456789", "john@example.com", "123 Main St", "password123", new Date(1990, 5, 15));
        Customer customer2 = new Customer("Alice", "Smith", "987654321", "alice@example.com", "456 Elm St", "password456", new Date(1985, 8, 25));
        Customer customer3 = new Customer("Cem", "Dirman", "1235687420", "cemdrman@example.com", "Bahcelievler Istanbul", "newPassword", null);
        Customer customer4 = new Customer("Gamze", "Madan", "1012369985", "gamze@example.com", "Urla Izmir", "Helloworld", null);

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);

        Product xLaptop = new Product("X Laptop", Category.ELECTRONICS, 999.9, 25);
        Product yLipstick = new Product("Y Lipstick", Category.BEAUTY, 25.5, 100);
        Product gamingConsole = new Product("N Gaming Console", Category.ELECTRONICS, 857.23, 15);
        Product adiShorts = new Product("adiShorts", Category.FASHION, 59.9, 70);

    }
}
