package com.patika.ecommerceservice;

import com.patika.ecommerceservice.enums.Category;
import com.patika.ecommerceservice.manager.ObjectManager;
import com.patika.ecommerceservice.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ObjectManager objectManager = ObjectManager.getInstance();

        Customer customer1 = objectManager.createCustomer("John", "Doe", "123456789", "john@example.com", "123 Main St", "password123", LocalDate.of(2000, 5, 4));
        Customer customer2 = objectManager.createCustomer("Alice", "Smith", "987654321", "alice@example.com", "456 Elm St", "password456", LocalDate.of(1993, 12, 1));
        Customer customer3 = objectManager.createCustomer("Cem", "Dirman", "1235687420", "cemdrman@example.com", "Bahcelievler Istanbul", "newPassword", LocalDate.of(1995, 7, 13));
        Customer customer4 = objectManager.createCustomer("Gamze", "Madan", "1012369985", "gamze@example.com", "Urla Izmir", "Helloworld", LocalDate.of(1997, 7, 18));

        Product xLaptop = objectManager.createProduct("X Laptop", Category.ELECTRONICS, 999.9, 25);
        Product yLipstick = objectManager.createProduct("Y Lipstick", Category.BEAUTY, 25.5, 100);
        Product gamingConsole = objectManager.createProduct("N Gaming Console", Category.ELECTRONICS, 857.23, 15);
        Product adiShorts = objectManager.createProduct("adiShorts", Category.FASHION, 59.9, 70);

        Order order1 = objectManager.createOrder(customer3);
        Order order2 = objectManager.createOrder(customer4);
        Order order3 = objectManager.createOrder(customer1);
        Order order4 = objectManager.createOrder(customer2);

        order1.addProduct(xLaptop, 1); 
        order1.addProduct(gamingConsole, 1); 
        order2.addProduct(yLipstick, 1); 
        order2.addProduct(adiShorts, 1);
        order2.addProduct(gamingConsole, 1);
        order3.addProduct(adiShorts, 2);
        order4.addProduct(xLaptop, 1);

        Bill bill1 = objectManager.createBill(order1);
        Bill bill2 = objectManager.createBill(order2);
        Bill bill3 = objectManager.createBill(order3);
        Bill bill4 = objectManager.createBill(order4);

        int allCustomers = objectManager.getCustomers().size();

        System.out.println("Sistemdeki tum musteri sayisi: "+allCustomers);

        //Siparisler uzerinden musterilere ulasilir ardindan isim eslemesi yapilir. Eslenen isim uzerinden urunlerin listesi alinir
        //count() metotu bu listede kac tane eleman oldugunu dondurur
        long productsBoughtByCem = objectManager.getOrders().stream()
        .filter(order -> order.getCustomer().getName().equals("Cem"))
        .flatMap((Order order) -> order.getProductList().stream()).count();

        System.out.println("İsmi Cem olan musterilerin aldigi urunlerin sayisi: "+productsBoughtByCem);
        
        //Burada uygulanan islem yukaridakine benzerdir
        List<Bill> cemsWithAgeLimitation = objectManager.getBills().stream()
        .filter(order -> order.getOrder().getCustomer().getName().equals("Cem") 
        && order.getOrder().getCustomer().getAge() < 30
        && 25 <order.getOrder().getCustomer().getAge())
        .collect(Collectors.toList());

        double totalFeeOfCems = cemsWithAgeLimitation.stream()
        .mapToDouble(Bill::getTotalAmount)
        .sum();

        System.out.println("Ismi Cem olup yasi 30'dan kucuk 25'ten buyuk musterilerin toplam alisveris tutari: "+totalFeeOfCems);

        List<Bill> feesWithOver1500 = objectManager.getBills().stream()
        .filter(bill -> bill.getTotalAmount() > 1500).
        collect(Collectors.toList());

        System.out.println("Sistemdeki 1500 TL üzeri olan faturalar: "+ feesWithOver1500);
    }
}
