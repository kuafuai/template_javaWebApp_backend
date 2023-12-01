package com.aiassistant.controller;

import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/googleSearchData")
    public ResultModel<List<String>> getGoogleSearchData() {
        return demoService.getGoogleSearchData();
    }

    @GetMapping("/googleSearchDataByHour")
    public ResultModel<List<String>> getGoogleSearchDataByHour() {
        return demoService.getGoogleSearchDataByHour();
    }
}
