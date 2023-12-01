package com.aiassistant.service.impl;

import com.aiassistant.mapper.DemoMapper;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    private final DemoMapper demoMapper;

    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    public ResultModel<List<String>> getGoogleSearchData() {
        List<String> googleSearchData = demoMapper.getGoogleSearchData();
        return ResultModel.ofSuccess(googleSearchData);
    }

    @Override
    public ResultModel<List<String>> getGoogleSearchDataByHour() {
        List<String> googleSearchDataByHour = demoMapper.getGoogleSearchDataByHour();
        return ResultModel.ofSuccess(googleSearchDataByHour);
    }
}
