package com.aiassistant.controller;

import com.aiassistant.model.Food;
import com.aiassistant.service.FoodService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/add")
    public ResultModel<Food> addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @DeleteMapping("/delete/{foodId}")
    public ResultModel deleteFood(@PathVariable Integer foodId) {
        return foodService.deleteFood(foodId);
    }

    @PutMapping("/update/{foodId}")
    public ResultModel updateFood(@PathVariable Integer foodId, @RequestBody Food food) {
        return foodService.updateFood(foodId, food);
    }

    @GetMapping("/category/{categoryId}")
    public ResultPageModel<Food> getFoodListByCategory(@PathVariable Integer categoryId) {
        return foodService.getFoodListByCategory(categoryId);
    }

    @GetMapping("/all")
    public ResultPageModel<Food> getAllFoodList() {
        return foodService.getAllFoodList();
    }
}
