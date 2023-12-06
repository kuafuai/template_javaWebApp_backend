package com.aiassistant.controller;

import com.aiassistant.service.SnakeService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnakeController {

    private final SnakeService snakeService;

    @Autowired
    public SnakeController(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @PostMapping("/addDirection")
    public ResultModel<String> addDirection(@RequestBody String direction) {
        return snakeService.addDirection(direction);
    }
}
