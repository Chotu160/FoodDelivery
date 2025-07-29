package com.fooddelivery.controller;

import com.fooddelivery.dto.OrderDTO;
import com.fooddelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody Map<String, Object> request) {
        String customerName = request.get("customerName").toString();
        int foodItemId = Integer.parseInt(request.get("foodItemId").toString());
        int quantity = Integer.parseInt(request.get("quantity").toString());

        OrderDTO dto = orderService.placeOrder(customerName, foodItemId, quantity);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
}
