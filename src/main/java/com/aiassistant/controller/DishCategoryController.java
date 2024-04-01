package com.aiassistant.controller;

import com.aiassistant.model.DishCategory;
import com.aiassistant.service.DishCategoryService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishCategory")
public class DishCategoryController {
    @Autowired
    private DishCategoryService dishCategoryService;

    @PostMapping("/add")
    public ResultModel<DishCategory> addDishCategory(@RequestBody DishCategory dishCategory) {
        return dishCategoryService.addDishCategory(dishCategory);
    }

    @PostMapping("/update")
    public ResultModel<DishCategory> updateDishCategory(@RequestBody DishCategory dishCategory) {
        return dishCategoryService.updateDishCategory(dishCategory);
    }

    @GetMapping("/delete")
    public ResultModel<DishCategory> deleteDishCategory(@RequestParam Integer categoryId) {
        return dishCategoryService.deleteDishCategory(categoryId);
    }

    @GetMapping("/list")
    public ResultPageModel<DishCategory> getDishCategoryList(@RequestParam(required = false) String categoryName) {
        return dishCategoryService.getDishCategoryList(categoryName);
    }
}
