package com.fooddelivery.dto;

public class OrderDTO {

    private Long orderId;
    private String customerName;
    private String foodItemName;
    private double price;
    private int quantity;
    private double totalAmount;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, String customerName, String foodItemName, double price, int quantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItemName = foodItemName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = price * quantity;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}