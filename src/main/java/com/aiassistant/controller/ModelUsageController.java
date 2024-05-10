package com.aiassistant.controller;

import com.aiassistant.service.ModelUsageService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/model-usage")
public class ModelUsageController {
    private final ModelUsageService modelUsageService;

    @Autowired
    public ModelUsageController(ModelUsageService modelUsageService) {
        this.modelUsageService = modelUsageService;
    }

    @PostMapping("/save")
    public ResultModel<String> saveModelUsage() {
        try {
            modelUsageService.saveModelUsage();
            return ResultModel.ofSuccess("Model usage saved successfully");
        } catch (Exception e) {
            return ResultModel.ofError("Failed to save model usage", e);
        }
    }
}
