package com.fooddelivery.service;

import com.fooddelivery.model.Restaurant;
import com.fooddelivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
