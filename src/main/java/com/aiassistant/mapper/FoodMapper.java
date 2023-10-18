package com.aiassistant.mapper;

import com.aiassistant.model.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoodMapper {
    @Insert("INSERT INTO food(name, image, categoryId, price, remark, otherParams) " +
            "VALUES(#{name}, #{image}, #{categoryId}, #{price}, #{remark}, #{otherParams})")
    @Options(useGeneratedKeys = true, keyProperty = "foodId", keyColumn = "foodId")
    int insertFood(Food food);

    @Delete("DELETE FROM food WHERE foodId = #{foodId}")
    void deleteById(Integer foodId);

    @Select("SELECT * FROM food WHERE foodId = #{foodId}")
    Food selectById(Integer foodId);

    @Select("SELECT * FROM food WHERE categoryId = #{categoryId}")
    List<Food> selectByCategoryId(Integer categoryId);

    @Select("SELECT * FROM food")
    List<Food> selectAll();
}
