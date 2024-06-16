package com.aiassistant.controller;

import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/generateEmojis")
    public ResultModel<List<String>> generateEmojis(@RequestParam String text, @RequestParam int numEmojis) {
        try {
            List<String> emojis = demoService.generateEmojis(text, numEmojis);
            return ResultModel.ofSuccess(emojis);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to generate emojis", e);
        }
    }
}
