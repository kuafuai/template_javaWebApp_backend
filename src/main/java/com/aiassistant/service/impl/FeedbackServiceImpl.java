package com.aiassistant.service.impl;

import com.aiassistant.mapper.FeedbackMapper;
import com.aiassistant.model.Feedback;
import com.aiassistant.service.FeedbackService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackMapper feedbackMapper) {
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public ResultModel addFeedback(Feedback feedback) {
        try {
            feedback.setCreatedAt(new Date());
            feedbackMapper.insertFeedback(feedback);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add feedback", e);
        }
    }

    @Override
    public ResultPageModel<Feedback> getFeedbackList() {

        return ResultPageModel.of(feedbackMapper.getFeedbackList());
    }

    @Override
    public Feedback getById(Integer id) {
        return feedbackMapper.selectById(id);
    }
}
