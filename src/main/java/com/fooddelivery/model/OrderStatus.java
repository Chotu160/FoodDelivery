package com.fooddelivery.model;

public enum OrderStatus {
    PENDING("Order placed, waiting for confirmation"),
    CONFIRMED("Order confirmed by restaurant"),
    PREPARING("Food is being prepared"),
    OUT_FOR_DELIVERY("Order is out for delivery"),
    DELIVERED("Order delivered successfully"),
    CANCELLED("Order cancelled");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
