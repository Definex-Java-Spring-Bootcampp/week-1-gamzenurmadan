package com.patika.ecommerceservice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> productList;
    private Customer customer;
    private LocalDate orderDate;

    public Order(Customer customer, LocalDate orderDate) {
        this.productList = new ArrayList<>();
        this.customer = customer;
        this.orderDate = orderDate;
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
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
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
}
