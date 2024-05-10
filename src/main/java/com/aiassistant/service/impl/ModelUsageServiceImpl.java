package com.aiassistant.service.impl;

import com.aiassistant.mapper.ModelUsageMapper;
import com.aiassistant.model.ModelUsage;
import com.aiassistant.service.ModelUsageService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelUsageServiceImpl implements ModelUsageService {

    private final ModelUsageMapper modelUsageMapper;

    @Autowired
    public ModelUsageServiceImpl(ModelUsageMapper modelUsageMapper) {
        this.modelUsageMapper = modelUsageMapper;
    }

    @Override
    public ResultModel saveModelUsage(ModelUsage modelUsage) {
        try {
            int result = modelUsageMapper.insertModelUsage(modelUsage);
            if (result > 0) {
                return ResultModel.ofSuccess();
            } else {
                throw new Exception("Failed to insert model usage");
            }
        } catch (Exception e) {
            return ResultModel.ofError(e.getMessage(), e);
        }
    }
}
