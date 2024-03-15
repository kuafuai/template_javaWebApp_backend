package com.aiassistant.mapper;

import com.aiassistant.model.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackMapper {
    @Insert("INSERT INTO feedback (store_id, feedback, image_url) VALUES (#{storeId}, #{feedback}, #{imageUrl})")
    void insertFeedback(Feedback feedback);
}
