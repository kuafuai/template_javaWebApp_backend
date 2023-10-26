package com.aiassistant.service.impl;

import com.aiassistant.mapper.FeedbackMapper;
import com.aiassistant.model.Feedback;
import com.aiassistant.service.FeedbackService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
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
    public ResultModel addFeedback(Feedback feedback) {
        try {
            feedbackMapper.insertFeedback(feedback);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add feedback", e);
        }
    }

    @Override
    public ResultPageModel<Feedback> getFeedbackList() {
        try {
            ResultPageModel<Feedback> resultPageModel = new ResultPageModel<>();
            resultPageModel.setList(feedbackMapper.getFeedbackList());
            resultPageModel.setTotalRecords(resultPageModel.getList().size());
            return resultPageModel;
        } catch (Exception e) {
            return ResultPageModel.ofResult(0, "Failed to get feedback list", null, e);
        }
    }

    @Override
    public Feedback getById(Integer id) {
        return feedbackMapper.selectById(id);
    }
}
