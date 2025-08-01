package com.fooddelivery.service;

import com.fooddelivery.dto.OrderDTO;
import com.fooddelivery.model.FoodItem;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.OrderStatus;
import com.fooddelivery.repository.FoodItemRepository;
import com.fooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    public OrderDTO placeOrder(String customerName, int foodItemId, int quantity) {
        FoodItem foodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new RuntimeException("Food item not found with id: " + foodItemId));

        Order order = new Order(customerName, foodItem, quantity);
        Order savedOrder = orderRepository.save(order);

        return new OrderDTO(
                savedOrder.getId(),
                savedOrder.getCustomerName(),
                foodItem.getName(),
                foodItem.getPrice(),
                savedOrder.getQuantity()
        );
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> {
                    FoodItem foodItem = order.getFoodItem();
                    if (foodItem == null) {
                        throw new IllegalStateException("FoodItem not found for order: " + order.getId());
                    }
                    return new OrderDTO(
                            order.getId(),
                            order.getCustomerName(),
                            foodItem.getName(),
                            foodItem.getPrice(),
                            order.getQuantity()
                    );
                })
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        FoodItem foodItem = order.getFoodItem();
        return new OrderDTO(
                order.getId(),
                order.getCustomerName(),
                foodItem.getName(),
                foodItem.getPrice(),
                order.getQuantity()
        );
    }

    @Transactional
    public OrderDTO updateOrderStatus(Long id, String statusString) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        try {
            OrderStatus status = OrderStatus.valueOf(statusString.toUpperCase());
            order.setStatus(status);
            Order updatedOrder = orderRepository.save(order);

            FoodItem foodItem = updatedOrder.getFoodItem();
            return new OrderDTO(
                    updatedOrder.getId(),
                    updatedOrder.getCustomerName(),
                    foodItem.getName(),
                    foodItem.getPrice(),
                    updatedOrder.getQuantity()
            );
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid order status: " + statusString);
        }
    }

    @Transactional
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new RuntimeException("Cannot cancel delivered order");
        }

        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}