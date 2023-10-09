package com.aiassistant.service;

import com.aiassistant.mapper.FoodMapper;
import com.aiassistant.model.Food;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    private final FoodMapper foodMapper;

    @Autowired
    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public ResultModel<Food> addFood(Food food) {
        try {
            foodMapper.insertFood(food);
            return ResultModel.ofSuccess(food);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add food", e);
        }
    }

    public ResultModel deleteFood(Integer foodId) {
        try {
            foodMapper.deleteFood(foodId);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to delete food", e);
        }
    }

    public ResultModel updateFood(Integer foodId, Food food) {
        try {
            foodMapper.updateFood(foodId, food);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update food", e);
        }
    }

    public ResultPageModel<Food> getFoodListByCategory(Integer categoryId) {
        try {
            ResultPageModel<Food> resultPageModel = new ResultPageModel<>();
            resultPageModel.setList(foodMapper.selectFoodListByCategory(categoryId));
            return resultPageModel;
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get food list by category", e);
        }
    }

    public ResultPageModel<Food> getAllFoodList() {
        try {
            ResultPageModel<Food> resultPageModel = new ResultPageModel<>();
            resultPageModel.setList(foodMapper.selectAllFoodList());
            return resultPageModel;
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get all food list", e);
        }
    }
}
