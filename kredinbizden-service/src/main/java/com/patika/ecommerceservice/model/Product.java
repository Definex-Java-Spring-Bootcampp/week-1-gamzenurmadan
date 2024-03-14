package com.patika.ecommerceservice.model;

import com.patika.ecommerceservice.enums.Category;

public class Product {
    private String name;
    private Category category;
    private double price;
    private int stock;

    public Product(String name, Category category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", category=" + category + ", price=" + price + ", stock=" + stock + "]";
    }
}
