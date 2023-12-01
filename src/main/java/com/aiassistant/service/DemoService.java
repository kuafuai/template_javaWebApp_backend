package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;

import java.util.List;

public interface DemoService {
    ResultModel<List<String>> getGoogleSearchData();

    ResultModel<List<String>> getGoogleSearchDataByHour();
}
