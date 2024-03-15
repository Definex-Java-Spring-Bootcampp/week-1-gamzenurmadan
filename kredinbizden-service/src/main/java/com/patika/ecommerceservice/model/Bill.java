package com.patika.ecommerceservice.model;
import java.util.concurrent.ThreadLocalRandom;

public class Bill {
    private Order order;
    private double totalAmount;
    private int billId;

    public Bill(Order order) {
        this.order = order;
        calculateTotal();
        this.billId = ThreadLocalRandom.current().nextInt();
    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public int getBillId(){
        return billId;
    }
    //order tamamlandiktan sonra toplam fiyat hesaplamasi yapilir
    private void calculateTotal(){
        totalAmount = order.getProductList().stream().mapToDouble(Product::getPrice).sum();
        totalAmount += totalAmount * 8/100; //added tax fee
    }

    @Override
    public String toString() {
        return "Bill [order=" + order + ", totalAmount=" + totalAmount + ", billId=" + billId + "]";
    }
    
}
