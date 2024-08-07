package com.aiassistant.mapper;

import com.aiassistant.model.WeatherData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface WeatherDataMapper {
    
    @Select("SELECT * FROM weather_data WHERE date = #{date}")
    WeatherData selectWeatherDataByDate(Date date);
}
