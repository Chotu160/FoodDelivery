package com.fooddelivery.controller;

import com.fooddelivery.dto.FoodItemDTO;
import com.fooddelivery.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    // Authenticated users can view food items
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<FoodItemDTO>> getAllFoodItems() {
        return ResponseEntity.ok(foodItemService.getAllFoodItems());
    }

    // Authenticated users can view single food item
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<FoodItemDTO> getFoodItem(@PathVariable int id) {
        return ResponseEntity.ok(foodItemService.getFoodItemById(id));
    }

    // Only ADMIN can add food items
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<FoodItemDTO> saveFoodItem(@Valid @RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO created = foodItemService.addFoodItem(foodItemDTO);
        return ResponseEntity.status(201).body(created);
    }

    // Only ADMIN can update food items
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<FoodItemDTO> updateFoodItem(@PathVariable int id, @Valid @RequestBody FoodItemDTO foodItemDTO) {
        return ResponseEntity.ok(foodItemService.updateFoodItem(id, foodItemDTO));
    }

    // Only ADMIN can delete food items
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable int id) {
        foodItemService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }
}
