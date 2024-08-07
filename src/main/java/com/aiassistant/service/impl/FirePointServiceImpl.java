package com.aiassistant.service.impl;

import com.aiassistant.mapper.FirePointMapper;
import com.aiassistant.mapper.WeatherDataMapper;
import com.aiassistant.model.FirePoint;
import com.aiassistant.model.WeatherData;
import com.aiassistant.service.FirePointService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FirePointServiceImpl implements FirePointService {

    @Autowired
    private FirePointMapper firePointMapper;

    @Autowired
    private WeatherDataMapper weatherDataMapper;

    @Override
    public ResultModel<FirePoint> getFirePointById(String id) {
        FirePoint firePoint = firePointMapper.selectFirePointById(id);
        if (firePoint == null) {
            return ResultModel.ofError("Fire point not found");
        }
        return ResultModel.ofSuccess(firePoint);
    }

    @Override
    public ResultModel<WeatherData> getWeatherDataByDate(Date date) {
        WeatherData weatherData = weatherDataMapper.selectWeatherDataByDate(date);
        if (weatherData == null) {
            return ResultModel.ofError("Weather data not found");
        }
        return ResultModel.ofSuccess(weatherData);
    }

    @Override
    public ResultModel<List<String>> manageUserPermissions(String userId, String action) {
        // Permission management logic can be implemented here
        // For illustration, assume permissions are returned based on action
        List<String> permissions = List.of("READ", "WRITE"); // Example permissions
        return ResultModel.ofSuccess(permissions);
    }
}
