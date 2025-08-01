package com.fooddelivery.service;

import com.fooddelivery.dto.FoodItemDTO;
import com.fooddelivery.model.FoodItem;
import com.fooddelivery.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public FoodItemDTO getFoodItemById(int id) {
        FoodItem foodItem = foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found with id: " + id));
        return convertToDTO(foodItem);
    }

    @Transactional
    public FoodItemDTO updateFoodItem(int id, FoodItemDTO dto) {
        FoodItem existingItem = foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found with id: " + id));

        existingItem.setName(dto.getFoodItemName());
        existingItem.setPrice(dto.getPrice());
        existingItem.setRestaurantId(dto.getRestaurantId());

        FoodItem updated = foodItemRepository.save(existingItem);
        return convertToDTO(updated);
    }

    @Transactional
    public void deleteFoodItem(int id) {
        if (!foodItemRepository.existsById(id)) {
            throw new RuntimeException("Food item not found with id: " + id);
        }
        foodItemRepository.deleteById(id);
    }

    private FoodItemDTO convertToDTO(FoodItem foodItem) {
        return new FoodItemDTO(
                foodItem.getId(), foodItem.getName(), foodItem.getPrice(), foodItem.getRestaurantId()
        );
    }
}
