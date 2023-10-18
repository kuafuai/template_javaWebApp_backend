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

    public ResultModel addFood(Food food) {
        // 校验请求体参数，确保必填字段不为空
        if (food.getName() == null || food.getName().isEmpty() ||
                food.getImage() == null || food.getImage().isEmpty() ||
                food.getCategoryId() == null || food.getCategoryId() <= 0 ||
                food.getPrice() == null || food.getPrice().compareTo(0) <= 0) {
            return ResultModel.ofError("Invalid request body");
        }

        // 调用FoodMapper的insertFood方法将餐品信息保存到数据库中
        foodMapper.insertFood(food);

        // 返回创建成功的餐品信息
        return ResultModel.ofSuccess(food);
    }

    public ResultModel deleteFood(Integer foodId) {
        // 校验foodId，确保foodId存在
        if (foodMapper.selectById(foodId) == null) {
            return ResultModel.ofError("Food not found");
        }

        // 调用FoodMapper的deleteById方法从数据库中删除对应的餐品信息
        foodMapper.deleteById(foodId);

        // 返回删除成功的消息
        return ResultModel.ofSuccess();
    }

    public ResultModel updateFood(Integer foodId, Food food) {
        // 校验foodId，确保foodId存在
        if (foodMapper.selectById(foodId) == null) {
            return ResultModel.ofError("Food not found");
        }

        // 更新餐品信息
        food.setFoodId(foodId);

        // 调用FoodMapper的updateById方法保存到数据库中
        foodMapper.updateById(food);

        // 返回更新成功的餐品信息
        return ResultModel.ofSuccess(food);
    }

    public ResultPageModel<Food> getFoodListByCategory(Integer categoryId) {
        // 调用FoodMapper的selectByCategoryId方法从数据库中查询对应分类下的餐品信息
        return ResultPageModel.of(foodMapper.selectByCategoryId(categoryId));
    }

    public ResultPageModel<Food> getAllFoodList() {
        // 调用FoodMapper的selectAll方法从数据库中查询所有餐品信息
        return ResultPageModel.of(foodMapper.selectAll());
    }
}
