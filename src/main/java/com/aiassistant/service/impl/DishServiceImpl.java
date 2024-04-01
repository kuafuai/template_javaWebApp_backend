package com.aiassistant.service.impl;

import com.aiassistant.mapper.DishMapper;
import com.aiassistant.model.Dish;
import com.aiassistant.service.DishService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishMapper dishMapper;

    @Autowired
    public DishServiceImpl(DishMapper dishMapper) {
        this.dishMapper = dishMapper;
    }

    @Override
    public ResultModel<List<Dish>> getAllDishes() {
        try {
            List<Dish> dishes = dishMapper.getAllDishes();
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get all dishes", e);
        }
    }

    @Override
    public ResultModel<Dish> getDishById(int id) {
        try {
            Dish dish = dishMapper.getDishById(id);
            if (dish != null) {
                return ResultModel.ofSuccess(dish);
            } else {
                return ResultModel.ofError("Dish not found");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dish by id", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByCategory(String category) {
        try {
            List<Dish> dishes = dishMapper.getDishesByCategory(category);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by category", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByKeyword(String keyword) {
        try {
            List<Dish> dishes = dishMapper.getDishesByKeyword(keyword);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by keyword", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByPriceRange(double minPrice, double maxPrice) {
        try {
            List<Dish> dishes = dishMapper.getDishesByPriceRange(minPrice, maxPrice);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by price range", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRating(double minRating, double maxRating) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRating(minRating, maxRating);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by rating", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRestaurantId(int restaurantId) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRestaurantId(restaurantId);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by restaurant id", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRestaurantName(String restaurantName) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRestaurantName(restaurantName);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by restaurant name", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRestaurantAndCategory(int restaurantId, String category) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRestaurantAndCategory(restaurantId, category);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by restaurant and category", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRestaurantAndKeyword(int restaurantId, String keyword) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRestaurantAndKeyword(restaurantId, keyword);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by restaurant and keyword", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRestaurantAndPriceRange(int restaurantId, double minPrice, double maxPrice) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRestaurantAndPriceRange(restaurantId, minPrice, maxPrice);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by restaurant and price range", e);
        }
    }

    @Override
    public ResultModel<List<Dish>> getDishesByRestaurantAndRating(int restaurantId, double minRating, double maxRating) {
        try {
            List<Dish> dishes = dishMapper.getDishesByRestaurantAndRating(restaurantId, minRating, maxRating);
            return ResultModel.ofSuccess(dishes);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dishes by restaurant and rating", e);
        }
    }
}
