package com.example.mapper;

import com.example.entity.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoodMapper {

    @Insert("INSERT INTO food (food_code, name, description_title, description, image, status, category_id, original_price, current_price, discount, creator, create_time, modifier, modify_time, remark, deleted) " +
            "VALUES (#{food.foodCode}, #{food.name}, #{food.descriptionTitle}, #{food.description}, #{food.image}, #{food.status}, #{food.categoryId}, #{food.originalPrice}, #{food.currentPrice}, #{food.discount}, #{food.creator}, #{food.createTime}, #{food.modifier}, #{food.modifyTime}, #{food.remark}, #{food.deleted})")
    void insertFood(@Param("food") Food food);

    @Select("SELECT * FROM food WHERE food_id = #{foodId}")
    Food selectFoodById(@Param("foodId") int foodId);

    @Update("UPDATE food SET food_code = #{food.foodCode}, name = #{food.name}, description_title = #{food.descriptionTitle}, description = #{food.description}, image = #{food.image}, status = #{food.status}, category_id = #{food.categoryId}, original_price = #{food.originalPrice}, current_price = #{food.currentPrice}, discount = #{food.discount}, modifier = #{food.modifier}, modify_time = #{food.modifyTime}, remark = #{food.remark} WHERE food_id = #{food.foodId}")
    void updateFood(@Param("food") Food food);

    @Delete("DELETE FROM food WHERE food_id = #{foodId}")
    void deleteFood(@Param("foodId") int foodId);

    @Select("SELECT * FROM food")
    List<Food> selectAllFoods();
}
