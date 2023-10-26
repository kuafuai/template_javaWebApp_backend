package com.aiassistant.service;

import com.aiassistant.model.Feedback;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface FeedbackService {
    ResultModel addFeedback(Feedback feedback);

    ResultPageModel<Feedback> getFeedbackList();

    Feedback getById(Integer id);
}
