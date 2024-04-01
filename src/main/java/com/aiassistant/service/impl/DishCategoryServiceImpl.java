package com.aiassistant.service.impl;

import com.aiassistant.mapper.DishCategoryMapper;
import com.aiassistant.model.DishCategory;
import com.aiassistant.service.DishCategoryService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {

    private final DishCategoryMapper dishCategoryMapper;

    @Autowired
    public DishCategoryServiceImpl(DishCategoryMapper dishCategoryMapper) {
        this.dishCategoryMapper = dishCategoryMapper;
    }

    @Override
    public ResultModel<List<DishCategory>> getAllDishCategories() {
        try {
            List<DishCategory> dishCategories = dishCategoryMapper.getAllDishCategories();
            return ResultModel.ofSuccess(dishCategories);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dish categories", e);
        }
    }

    @Override
    public ResultModel<DishCategory> getDishCategoryById(int id) {
        try {
            DishCategory dishCategory = dishCategoryMapper.getDishCategoryById(id);
            if (dishCategory != null) {
                return ResultModel.ofSuccess(dishCategory);
            } else {
                return ResultModel.ofError("Dish category not found");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get dish category", e);
        }
    }

    @Override
    public ResultModel<DishCategory> addDishCategory(DishCategory dishCategory) {
        try {
            dishCategoryMapper.addDishCategory(dishCategory);
            return ResultModel.ofSuccess("Dish category added successfully", dishCategory);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add dish category", e);
        }
    }

    @Override
    public ResultModel<DishCategory> updateDishCategory(DishCategory dishCategory) {
        try {
            dishCategoryMapper.updateDishCategory(dishCategory);
            return ResultModel.ofSuccess("Dish category updated successfully", dishCategory);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update dish category", e);
        }
    }

    @Override
    public ResultModel<String> deleteDishCategory(int id) {
        try {
            dishCategoryMapper.deleteDishCategory(id);
            return ResultModel.ofSuccess("Dish category deleted successfully");
        } catch (Exception e) {
            return ResultModel.ofError("Failed to delete dish category", e);
        }
    }
}
