package com.aiassistant.service;

import com.aiassistant.model.Feedback;
import com.aiassistant.utils.ResultModel;

public interface FeedbackService {
    ResultModel<Feedback> addFeedback(Feedback feedback);
}
