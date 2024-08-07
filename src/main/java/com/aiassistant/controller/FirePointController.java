package com.aiassistant.controller;

import com.aiassistant.model.FirePoint;
import com.aiassistant.model.WeatherData;
import com.aiassistant.service.FirePointService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/firepoint")
public class FirePointController {

    @Autowired
    private FirePointService firePointService;

    @GetMapping("/{id}")
    public ResultModel<FirePoint> getFirePoint(@PathVariable String id) {
        return firePointService.getFirePointById(id);
    }

    @GetMapping("/weather")
    public ResultModel<WeatherData> getWeather(@RequestParam Date date) {
        return firePointService.getWeatherDataByDate(date);
    }

    @PostMapping("/permissions")
    public ResultModel<List<String>> managePermissions(@RequestParam String userId, @RequestParam String permission) {
        return firePointService.manageUserPermissions(userId, permission);
    }
}
