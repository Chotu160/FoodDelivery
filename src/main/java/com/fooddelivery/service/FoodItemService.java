package com.fooddelivery.service;

import com.fooddelivery.FoodItemDTO;
import com.fooddelivery.model.FoodItem;
import com.fooddelivery.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItemDTO> getAllFoodItems() {
        return foodItemRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FoodItemDTO addFoodItem(FoodItemDTO dto) {
        FoodItem item = new FoodItem(
                dto.getFoodItemName(),
                dto.getPrice(),
                dto.getRestaurantId()

        );
        FoodItem saved = foodItemRepository.save(item);
        return convertToDTO(saved);
    }

    private FoodItemDTO convertToDTO(FoodItem foodItem) {
        return new FoodItemDTO(
                foodItem.getId(), foodItem.getName(), foodItem.getPrice(), foodItem.getRestaurantId()
        );

    }
}
