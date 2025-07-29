package com.fooddelivery.model;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    public Order() {}

    public Order(String customerName, FoodItem foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public FoodItem getFoodItem() { return foodItem; }

    public void setFoodItem(FoodItem foodItem) { this.foodItem = foodItem; }
}
