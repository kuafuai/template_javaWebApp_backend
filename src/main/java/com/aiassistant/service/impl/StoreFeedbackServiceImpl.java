package com.aiassistant.service;

import com.aiassistant.mapper.StoreFeedbackMapper;
import com.aiassistant.model.StoreFeedback;
import com.aiassistant.service.StoreFeedbackService;
import com.aiassistant.utils.ExcelUtils;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreFeedbackServiceImpl implements StoreFeedbackService {

    private final StoreFeedbackMapper storeFeedbackMapper;

    @Autowired
    public StoreFeedbackServiceImpl(StoreFeedbackMapper storeFeedbackMapper) {
        this.storeFeedbackMapper = storeFeedbackMapper;
    }

    @Override
    public ResultModel<StoreFeedback> addStoreFeedback(StoreFeedback storeFeedback) {
        storeFeedbackMapper.insertStoreFeedback(storeFeedback);
        return ResultModel.ofSuccess();
    }

    @Override
    public ResultModel<String> generateExcel() {
        List<StoreFeedback> storeFeedbackList = storeFeedbackMapper.getStoreFeedbackList();
        String filePath = ExcelUtils.generateExcel(storeFeedbackList);
        return ResultModel.ofSuccess(filePath);
    }

    @Override
    public ResultPageModel<StoreFeedback> getStoreFeedbackList() {
        List<StoreFeedback> storeFeedbackList = storeFeedbackMapper.getStoreFeedbackList();
        return ResultPageModel.of(storeFeedbackList);
    }

    @Override
    public ResultModel<StoreFeedback> getStoreFeedbackById(Integer id) {
        StoreFeedback storeFeedback = storeFeedbackMapper.selectById(id);
        return ResultModel.ofSuccess(storeFeedback);
    }

    @Override
    public ResultModel<String> deleteStoreFeedbackById(Integer id) {
        storeFeedbackMapper.deleteById(id);
        return ResultModel.ofSuccess();
    }

    @Override
    public ResultModel<String> updateStoreFeedback(StoreFeedback storeFeedback) {
        storeFeedbackMapper.updateById(storeFeedback);
        return ResultModel.ofSuccess();
    }
}