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
    public ResultModel addFood(@RequestBody Food food) {
        // 校验请求体参数
        if (food.getName() == null || food.getName().isEmpty() ||
                food.getImage() == null || food.getImage().isEmpty() ||
                food.getCategoryId() == null || food.getCategoryId() <= 0 ||
                food.getPrice() == null || food.getPrice().compareTo(0) <= 0) {
            return ResultModel.ofError("Invalid request body");
        }

        // 创建新的餐品信息，并保存到数据库中
        ResultModel result = foodService.addFood(food);
        if (result.getCode() == 0) {
            return ResultModel.ofSuccess("Food added successfully", result.getData());
        } else {
            return ResultModel.ofError("Failed to add food");
        }
    }

    @PostMapping("/delete")
    public ResultModel deleteFood(@RequestParam Integer foodId) {
        // 校验foodId
        if (foodId == null || foodId <= 0) {
            return ResultModel.ofError("Invalid foodId");
        }

        // 根据foodId从数据库中删除对应的餐品信息
        ResultModel result = foodService.deleteFood(foodId);
        if (result.getCode() == 0) {
            return ResultModel.ofSuccess("Food deleted successfully");
        } else {
            return ResultModel.ofError("Failed to delete food");
        }
    }

    @PostMapping("/update")
    public ResultModel updateFood(@RequestParam Integer foodId, @RequestBody Food food) {
        // 校验foodId
        if (foodId == null || foodId <= 0) {
            return ResultModel.ofError("Invalid foodId");
        }

        // 根据foodId从数据库中查询对应的餐品信息
        ResultModel<Food> result = foodService.getFoodById(foodId);
        if (result.getCode() != 0) {
            return ResultModel.ofError("Failed to update food");
        }

        // 更新餐品信息，并保存到数据库中
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
    public ResultPageModel<Food> getFoodListByCategory(@RequestParam Integer categoryId) {
        // 根据categoryId从数据库中查询对应分类下的餐品信息
        ResultPageModel<Food> result = foodService.getFoodListByCategory(categoryId);
        if (result.getCode() == 0) {
            return result;
        } else {
            return ResultPageModel.ofError("Failed to get food list");
        }
    }

    @GetMapping("/listAll")
    public ResultPageModel<Food> getAllFoodList() {
        // 从数据库中查询所有餐品信息
        ResultPageModel<Food> result = foodService.getAllFoodList();
        if (result.getCode() == 0) {
            return result;
        } else {
            return ResultPageModel.ofError("Failed to get food list");
        }
    }
}
