package com.aiassistant.mapper;

import com.aiassistant.model.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodMapper {
    Food insertFood(Food food);

    void deleteFood(Integer foodId);

    void updateFood(@Param("foodId") Integer foodId, @Param("food") Food food);

    List<Food> selectFoodListByCategory(Integer categoryId);

    List<Food> selectAllFoodList();
}
