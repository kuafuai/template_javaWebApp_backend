package com.aiassistant.controller;

import com.aiassistant.service.SnakeService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnakeController {
    @Autowired
    private SnakeService snakeService;

    @PostMapping("/snake")
    public ResultModel increaseLength(
            @RequestParam String direction,
            @RequestParam String food
    ) {
        return snakeService.increaseLength(direction, food);
    }
}
