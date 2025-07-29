package com.fooddelivery.controller;

import com.fooddelivery.FoodItemDTO;
import com.fooddelivery.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItemDTO> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @PostMapping
    public FoodItemDTO saveFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        return foodItemService.addFoodItem(foodItemDTO);
    }
}
