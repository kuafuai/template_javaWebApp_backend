package com.example.service;

import com.example.dto.FoodDto;
import com.example.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodMapper foodMapper;

    @Autowired
    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public FoodDto createFood(FoodDto foodDto) {
        foodMapper.insertFood(foodDto.toFood());
        return foodDto;
    }

    public FoodDto getFoodById(int foodId) {
        return foodMapper.selectFoodById(foodId).toFoodDto();
    }

    public FoodDto updateFood(int foodId, FoodDto foodDto) {
        foodDto.setFoodId(foodId);
        foodMapper.updateFood(foodDto.toFood());
        return foodDto;
    }

    public void deleteFood(int foodId) {
        foodMapper.deleteFood(foodId);
    }

    public List<FoodDto> getAllFoods() {
        return foodMapper.selectAllFoods().stream()
                .map(Food::toFoodDto)
                .collect(Collectors.toList());
    }
}
