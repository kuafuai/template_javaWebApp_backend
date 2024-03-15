package com.aiassistant.service;

import com.aiassistant.mapper.StoreFeedbackMapper;
import com.aiassistant.model.StoreFeedback;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreFeedbackService {
    private final StoreFeedbackMapper storeFeedbackMapper;

    @Autowired
    public StoreFeedbackService(StoreFeedbackMapper storeFeedbackMapper) {
        this.storeFeedbackMapper = storeFeedbackMapper;
    }

    @Transactional
    public ResultModel<StoreFeedback> addStoreFeedback(StoreFeedback storeFeedback) {
        storeFeedbackMapper.insertStoreFeedback(storeFeedback);
        return ResultModel.ofSuccess(storeFeedback);
    }

    public ResultPageModel<StoreFeedback> getStoreFeedbackList() {
        return ResultPageModel.of(storeFeedbackMapper.getStoreFeedbackList());
    }

    public StoreFeedback getStoreFeedbackById(Integer id) {
        return storeFeedbackMapper.selectById(id);
    }

    public ResultModel<StoreFeedback> deleteStoreFeedbackById(Integer id) {
        storeFeedbackMapper.deleteById(id);
        return ResultModel.ofSuccess();
    }

    public ResultModel<StoreFeedback> updateStoreFeedback(StoreFeedback storeFeedback) {
        storeFeedbackMapper.updateById(storeFeedback);
        return ResultModel.ofSuccess(storeFeedback);
    }
}
