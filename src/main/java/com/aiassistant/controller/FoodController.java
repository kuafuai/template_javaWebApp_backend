package com.aiassistant.controller;

import com.aiassistant.model.Food;
import com.aiassistant.service.FoodService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/food")
@Validated
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/add")
    public ResultModel addFood(@Valid @RequestBody Food food) {
        ResultModel result = foodService.addFood(food);
        if (result.getCode() == 0) {
            return ResultModel.ofSuccess("Food added successfully", result.getData());
        } else {
            return ResultModel.ofError("Failed to add food");
        }
    }

    @PostMapping("/delete")
    public ResultModel deleteFood(@Positive @RequestParam Integer foodId) {
        ResultModel result = foodService.deleteFood(foodId);
        if (result.getCode() == 0) {
            return ResultModel.ofSuccess("Food deleted successfully");
        } else {
            return ResultModel.ofError("Failed to delete food");
        }
    }

    @PostMapping("/update")
    public ResultModel updateFood(@Positive @RequestParam Integer foodId, @Valid @RequestBody Food food) {
        ResultModel<Food> result = foodService.getFoodById(foodId);
        if (result.getCode() != 0) {
            return ResultModel.ofError("Failed to update food");
        }

        Food existingFood = result.getData();
        existingFood.setName(food.getName());
        existingFood.setImage(food.getImage());
        existingFood.setCategoryId(food.getCategoryId());
        existingFood.setPrice(food.getPrice());
        existingFood.setRemark(food.getRemark());
        existingFood.setOtherParams(food.getOtherParams());

        ResultModel updateResult = foodService.updateFood(existingFood);
        if (updateResult.getCode() == 0) {
            return ResultModel.ofSuccess("Food updated successfully", updateResult.getData());
        } else {
            return ResultModel.ofError("Failed to update food");
        }
    }

    @GetMapping("/listByCategory")
    public ResultPageModel<Food> getFoodListByCategory(@Positive @RequestParam Integer categoryId) {
        ResultPageModel<Food> result = foodService.getFoodListByCategory(categoryId);
        if (result.getCode() == 0) {
            return result;
        } else {
            return ResultPageModel.ofError("Failed to get food list");
        }
    }

    @GetMapping("/listAll")
    public ResultPageModel<Food> getAllFoodList() {
        ResultPageModel<Food> result = foodService.getAllFoodList();
        if (result.getCode() == 0) {
            return result;
        } else {
            return ResultPageModel.ofError("Failed to get food list");
        }
    }
}
