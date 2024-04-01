package com.aiassistant.controller;

import com.aiassistant.model.Dish;
import com.aiassistant.service.DishService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {
    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/add")
    public ResultModel<Dish> addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PostMapping("/update")
    public ResultModel<Dish> updateDish(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
    }

    @PostMapping("/delete")
    public ResultModel<Dish> deleteDish(@RequestParam Integer dishId) {
        return dishService.deleteDish(dishId);
    }

    @GetMapping("/list")
    public ResultPageModel<Dish> getDishList(@RequestParam(required = false) String dishName,
                                             @RequestParam(required = false) Double minPrice,
                                             @RequestParam(required = false) Double maxPrice) {
        return dishService.getDishList(dishName, minPrice, maxPrice);
    }
}
