
package com.fooddelivery.dto;

public class OrderRequestDTO {
    private String customerName;
    private int foodItemId;
    private int quantity;

    public OrderRequestDTO() {}

    public OrderRequestDTO(String customerName, int foodItemId, int quantity) {
        this.customerName = customerName;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
