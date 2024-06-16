package com.aiassistant.service.impl;

import com.aiassistant.mapper.DemoMapper;
import com.aiassistant.model.Demo;
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
    public ResultModel<List<String>> generateEmojis(String text, int numEmojis) {
        try {
            List<String> emojis = demoMapper.generateEmojis(text, numEmojis);
            return ResultModel.ofSuccess(emojis);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to generate emojis", e);
        }
    }
}
