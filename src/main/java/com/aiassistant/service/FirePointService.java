package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.FirePoint;
import com.aiassistant.model.WeatherData;

import java.util.Date;
import java.util.List;

public interface FirePointService {
    ResultModel<FirePoint> getFirePointById(String id);
    ResultModel<WeatherData> getWeatherDataByDate(Date date);
    ResultModel<List<String>> manageUserPermissions(String userId, String action);
}
