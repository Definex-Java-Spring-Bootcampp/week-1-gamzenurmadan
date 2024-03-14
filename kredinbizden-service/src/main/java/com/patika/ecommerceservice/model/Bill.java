package com.patika.ecommerceservice.model;

public class Bill {
    private Order order;
    private double totalAmount;

    public Bill(Order order) {
        this.order = order;
        calculateTotal();
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    private void calculateTotal(){
        totalAmount = order.getProductList().stream().mapToDouble(Product::getPrice).sum();
        totalAmount += totalAmount * 100/8; //added tax fee
    }
    
}
