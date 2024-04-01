package com.aiassistant.service;

import com.aiassistant.model.DishCategory;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface DishCategoryService {
    ResultModel<DishCategory> addDishCategory(DishCategory dishCategory);

    ResultModel<DishCategory> updateDishCategory(DishCategory dishCategory);

    ResultModel<DishCategory> deleteDishCategory(Integer categoryId);

    ResultPageModel<DishCategory> getDishCategoryList(String categoryName);
}
