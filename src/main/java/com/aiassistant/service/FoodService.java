package com.aiassistant.service;

import com.aiassistant.mapper.FoodMapper;
import com.aiassistant.model.Food;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
public class FoodService {
    private final FoodMapper foodMapper;

    @Autowired
    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public ResultModel addFood(@Valid Food food) {
        // Validate the food object
        if (food.getName() == null || food.getName().isEmpty()) {
            return ResultModel.ofError("Food name is required");
        }
        if (food.getCategoryId() == null) {
            return ResultModel.ofError("Food category is required");
        }
        if (food.getPrice() == null) {
            return ResultModel.ofError("Food price is required");
        }

        // Call FoodMapper's insertFood method to save the food information to the database
        foodMapper.insertFood(food);

        // Return the created food information
        return ResultModel.ofSuccess(food);
    }

    public ResultModel deleteFood(@NotNull Integer foodId) {
        // Check if the foodId exists
        if (!foodExists(foodId)) {
            return ResultModel.ofError("Food not found");
        }

        // Call FoodMapper's deleteById method to delete the corresponding food information from the database
        foodMapper.deleteById(foodId);

        // Return the success message
        return ResultModel.ofSuccess();
    }

    public ResultModel updateFood(@NotNull Integer foodId, @Valid Food food) {
        // Check if the foodId exists
        if (!foodExists(foodId)) {
            return ResultModel.ofError("Food not found");
        }

        // Update the food information
        food.setFoodId(foodId);

        // Call FoodMapper's updateById method to save the updated food information to the database
        foodMapper.updateById(food);

        // Return the updated food information
        return ResultModel.ofSuccess(food);
    }

    public ResultPageModel<Food> getFoodListByCategory(@NotNull @Min(1) Integer categoryId, @Min(1) int pageNum, @Min(1) int pageSize) {
        // Validate the pageNum and pageSize values
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }

        // Call FoodMapper's selectByCategoryId method to query the food information for the specified category
        int total = foodMapper.countByCategoryId(categoryId);
        int offset = (pageNum - 1) * pageSize;
        return ResultPageModel.of(foodMapper.selectByCategoryId(categoryId, offset, pageSize), total, pageNum, pageSize);
    }

    public ResultPageModel<Food> getAllFoodList(@Min(1) int pageNum, @Min(1) int pageSize) {
        // Validate the pageNum and pageSize values
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }

        // Call FoodMapper's selectAll method to query all food information
        int total = foodMapper.countAll();
        int offset = (pageNum - 1) * pageSize;
        return ResultPageModel.of(foodMapper.selectAll(offset, pageSize), total, pageNum, pageSize);
    }

    public Food getFoodById(Integer foodId) {
        // Call FoodMapper's selectById method to query the food information for the specified foodId
        return foodMapper.selectById(foodId);
    }

    private boolean foodExists(Integer foodId) {
        return foodMapper.selectById(foodId) != null;
    }
}
