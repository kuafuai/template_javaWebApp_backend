package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import com.aiassistant.model.UserFeedback;

public interface UserFeedbackService {
    ResultModel<UserFeedback> submitFeedback(UserFeedback feedback);
    ResultPageModel<UserFeedback> getFeedbackList(int pageNo, int pageSize);
    ResultModel<UserFeedback> getFeedbackById(Integer feedbackId);
}
