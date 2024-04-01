package com.aiassistant.service;

import com.aiassistant.model.Dish;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface DishService {
    ResultModel<Dish> addDish(Dish dish);
    ResultModel<Dish> updateDish(Dish dish);
    ResultModel<Dish> deleteDish(Integer dishId);
    ResultPageModel<Dish> getDishList(String dishName, Double minPrice, Double maxPrice);
}
