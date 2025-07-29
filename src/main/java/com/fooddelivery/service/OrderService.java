package com.fooddelivery.service;

import com.fooddelivery.dto.OrderDTO;
import com.fooddelivery.model.FoodItem;
import com.fooddelivery.model.Order;
import com.fooddelivery.repository.FoodItemRepository;
import com.fooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("Food item not found"));

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
        return orderRepository.findAll().stream().map(order ->
                new OrderDTO(
                        order.getId(),
                        order.getCustomerName(),
                        order.getFoodItem().getName(),
                        order.getFoodItem().getPrice(),
                        order.getQuantity()
                )).collect(Collectors.toList());
    }
}
