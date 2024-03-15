package com.aiassistant.mapper;

import com.aiassistant.model.StoreFeedback;
import org.apache.ibatis.annotations.Insert;

public interface StoreFeedbackMapper {
    @Insert("INSERT INTO store_feedback (store_id, user_id, feedback_content, create_time) " +
            "VALUES (#{storeId}, #{userId}, #{feedbackContent}, #{createTime})")
    StoreFeedback insertStoreFeedback(StoreFeedback storeFeedback);
}
