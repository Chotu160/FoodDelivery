package com.fooddelivery.dto;

public class OrderDTO {

    private Long orderId;
    private String customerName;
    private String foodItemName;
    private double price;
    private int quantity;
    private double totalAmount;

    public OrderDTO(Long orderId, String customerName, String foodItemName, double price, int quantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItemName = foodItemName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = price * quantity;
    }

    // Getters and Setters
    public Long getOrderId() { return orderId; }

    public String getCustomerName() { return customerName; }

    public String getFoodItemName() { return foodItemName; }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public double getTotalAmount() { return totalAmount; }
}
