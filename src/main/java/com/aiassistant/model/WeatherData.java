package com.aiassistant.model;

import lombok.Data;
import java.util.Date;

@Data
public class WeatherData {
    private Date date;
    private Double precipitation;
    private Double windSpeed;
}
