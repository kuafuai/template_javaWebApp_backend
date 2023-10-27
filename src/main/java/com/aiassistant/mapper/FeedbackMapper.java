package com.aiassistant.mapper;

import com.aiassistant.model.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FeedbackMapper {

    @Insert("INSERT INTO feedback (store_name,feedback_text, image_url, created_at) VALUES (#{storeName},#{feedbackText},#{imageUrl},#{createdAt})")
    void insertFeedback(Feedback feedback);

    @Select("select * from feedback order by id desc")
    List<Feedback> getFeedbackList();

    @Select("select * from feedback where id = #{id}")
    Feedback selectById(Integer id);
}
