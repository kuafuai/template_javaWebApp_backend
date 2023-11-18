package com.aiassistant.service;

import com.aiassistant.mapper.PositionMapper;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionMapper positionMapper;

    @Autowired
    public PositionService(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    public ResultModel<List<String>> getPositionList() {
        try {
            List<String> positionList = positionMapper.getPositionList();
            return ResultModel.ofSuccess(positionList);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get position list", e);
        }
    }
}
