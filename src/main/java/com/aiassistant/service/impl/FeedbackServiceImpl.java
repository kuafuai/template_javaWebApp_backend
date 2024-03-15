package com.aiassistant.service.impl;

import com.aiassistant.mapper.FeedbackMapper;
import com.aiassistant.model.Feedback;
import com.aiassistant.service.FeedbackService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public ResultModel<Feedback> addFeedback(Feedback feedback) {
        // 验证门店ID是否存在
        if (feedback.getStoreId() == null || feedback.getStoreId().isEmpty()) {
            return ResultModel.ofError("Store ID cannot be empty");
        }

        // 验证反馈信息是否为空
        if (feedback.getFeedback() == null || feedback.getFeedback().isEmpty()) {
            return ResultModel.ofError("Feedback cannot be empty");
        }

        // 验证图片地址是否为空
        if (feedback.getImageUrl() == null || feedback.getImageUrl().isEmpty()) {
            return ResultModel.ofError("Image URL cannot be empty");
        }

        // 保存反馈信息到数据库
        feedbackMapper.insertFeedback(feedback);

        return ResultModel.ofSuccess("Feedback added successfully", feedback);
    }
}
