package com.patika.ecommerceservice.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.patika.ecommerceservice.enums.Category;
import com.patika.ecommerceservice.model.Bill;
import com.patika.ecommerceservice.model.Customer;
import com.patika.ecommerceservice.model.Order;
import com.patika.ecommerceservice.model.Product;

public class ObjectManager {
    private static ObjectManager instance;
    private List<Customer> customers;
    private List<Product> products;
    private List<Bill> bills;
    private List<Order> orders;

    private ObjectManager() {
        customers = new ArrayList<>();
        bills = new ArrayList<>();
        orders = new ArrayList<>();
        products = new ArrayList<>();
    }

    public static ObjectManager getInstance() {
        if (instance == null) {
            instance = new ObjectManager();
        }
        return instance;
    }

    public Customer createCustomer(String name, String surname, String phoneNumber, String email, String address, String password, LocalDate birthdate) {
        Customer customer = new Customer(name, surname, phoneNumber, email, address, password, birthdate);
        customers.add(customer);
        return customer;
    }

    public Product createProduct(String name, Category category, double price, int stock) {
        Product product = new Product(name, category, price, stock);
        products.add(product);
        return product;
    }

    public Bill createBill(Order order) {
        Bill bill = new Bill(order);
        bills.add(bill);
        return bill;
    }

    public Order createOrder(Customer customer) {
        Order order = new Order(customer);
        orders.add(order);
        customer.addOrder(order.getOrderId());
        return order;
    }

    public List<Bill> getBills(){
        return bills;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public List<Product> getProducts(){
        return products;
    }
}
