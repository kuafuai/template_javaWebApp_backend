package com.example.controller;

import com.example.dto.FoodDto;
import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<FoodDto> createFood(@RequestBody FoodDto foodDto) {
        FoodDto createdFood = foodService.createFood(foodDto);
        return ResponseEntity.ok(createdFood);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodDto> getFoodById(@PathVariable int foodId) {
        FoodDto food = foodService.getFoodById(foodId);
        return ResponseEntity.ok(food);
    }

    @PutMapping("/{foodId}")
    public ResponseEntity<FoodDto> updateFood(@PathVariable int foodId, @RequestBody FoodDto foodDto) {
        FoodDto updatedFood = foodService.updateFood(foodId, foodDto);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable int foodId) {
        foodService.deleteFood(foodId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAllFoods() {
        List<FoodDto> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }
}
