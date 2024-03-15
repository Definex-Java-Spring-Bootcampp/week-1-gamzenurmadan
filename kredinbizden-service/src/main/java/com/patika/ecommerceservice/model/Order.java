package com.patika.ecommerceservice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order {
    private List<Product> productList;
    private Customer customer;
    private LocalDate orderDate;
    private int orderId;

    public Order(Customer customer) {
        this.productList = new ArrayList<>();
        this.customer = customer;
        this.orderDate = LocalDate.now();
        this.orderId = ThreadLocalRandom.current().nextInt();
    }
    
    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderId(){
        return orderId;
    }

    public void addProduct(Product product, int amount){
        for(int i=0; i<amount; i++){
            if(amount<product.getStock()){
                productList.add(product);
            }else{
                System.out.println("Not enough "+ product.getName());
            }
        }
    }   
    @Override
    public String toString() {
        return "Order [productList=" + productList + ", customer=" + customer + ", orderDate=" + orderDate
                + ", orderId=" + orderId + "]";
    }
}
