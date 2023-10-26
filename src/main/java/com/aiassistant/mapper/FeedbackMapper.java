package com.aiassistant.mapper;

import com.aiassistant.model.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    Feedback insertFeedback(Feedback feedback);

    List<Feedback> getFeedbackList();

    Feedback selectById(Integer id);
}
