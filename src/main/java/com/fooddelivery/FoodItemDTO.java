package com.fooddelivery;

public class FoodItemDTO {
    private String foodItemName;
    private double price;
    private int restaurantId;
  private int id;
    public FoodItemDTO(int id,String foodItemName, double price, int restaurantId) {
        this.foodItemName = foodItemName;
        this.price = price;
        this.restaurantId = restaurantId;
        this.id = id;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
