package com.aiassistant.controller;

import com.aiassistant.model.AdditionResult;
import com.aiassistant.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdditionController {
    private final AdditionService additionService;

    @Autowired
    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @PostMapping("/add")
    public AdditionResult addNumbers(@RequestBody List<Integer> numbers) {
        return new AdditionResult(additionService.addNumbers(numbers));
    }

    @PostMapping("/subtract")
    public AdditionResult subtractNumbers(@RequestBody List<Integer> numbers) {
        return new AdditionResult(additionService.subtractNumbers(numbers));
    }
}