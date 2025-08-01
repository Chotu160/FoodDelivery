package com.fooddelivery.dto;

import jakarta.validation.constraints.*;

public class FoodItemDTO {
    private int id;

    @NotBlank(message = "Food item name is required")
    @Size(min = 2, max = 100, message = "Food item name must be between 2 and 100 characters")
    private String foodItemName;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @DecimalMax(value = "10000.0", message = "Price must be less than 10000")
    private double price;

    @NotNull(message = "Restaurant ID is required")
    @Min(value = 1, message = "Restaurant ID must be positive")
    private int restaurantId;

    // Default constructor
    public FoodItemDTO() {}

    // Constructor with all fields
    public FoodItemDTO(int id, String foodItemName, double price, int restaurantId) {
        this.id = id;
        this.foodItemName = foodItemName;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
