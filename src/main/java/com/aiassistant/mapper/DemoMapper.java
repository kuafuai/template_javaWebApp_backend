package com.aiassistant.mapper;

import com.aiassistant.model.GoogleSearchData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoMapper {
    @Insert("INSERT INTO google_search_data (keyword) VALUES (#{keyword})")
    void insertGoogleSearchData(String keyword);

    @Select("SELECT keyword FROM google_search_data ORDER BY id DESC LIMIT 10")
    List<String> getGoogleSearchData();

    @Select("SELECT keyword FROM google_search_data WHERE create_time >= DATE_SUB(NOW(), INTERVAL 1 HOUR) ORDER BY id DESC LIMIT 10")
    List<String> getGoogleSearchDataByHour();
}
