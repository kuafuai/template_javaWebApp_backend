package com.aiassistant.controller;

import com.aiassistant.model.Config;
import com.aiassistant.service.ConfigService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {
    private final ConfigService configService;

    @Autowired
    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @PostMapping("/add")
    public ResultModel addConfig(@RequestBody Config config) {
        return configService.addConfig(config);
    }

    @PostMapping("/updateValue")
    public ResultModel updateConfigValue(@RequestBody Config config) {
        return configService.updateConfigValue(config);
    }

    @PostMapping("/updateStatus")
    public ResultModel updateConfigStatus(@RequestBody Config config) {
        return configService.updateConfigStatus(config);
    }

    @GetMapping("/getValue")
    public ResultModel getConfigValue(@RequestParam String key, @RequestParam String defaultValue) {
        return configService.getConfigValue(key, defaultValue);
    }
}
