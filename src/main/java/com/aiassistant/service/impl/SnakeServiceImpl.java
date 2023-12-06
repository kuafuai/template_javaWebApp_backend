package com.aiassistant.service.impl;

import com.aiassistant.mapper.SnakeMapper;
import com.aiassistant.service.SnakeService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnakeServiceImpl implements SnakeService {

    private final SnakeMapper snakeMapper;

    @Autowired
    public SnakeServiceImpl(SnakeMapper snakeMapper) {
        this.snakeMapper = snakeMapper;
    }

    @Override
    public ResultModel<String> addDirection(String direction) {
        snakeMapper.insertDirection(direction);
        return ResultModel.ofSuccess();
    }
}
