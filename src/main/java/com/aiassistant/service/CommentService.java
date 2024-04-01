package com.aiassistant.service;

import com.aiassistant.model.Comment;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

import java.util.Date;

public interface CommentService {
    ResultModel<Comment> addComment(Comment comment);

    ResultPageModel<Comment> getCommentList(Double minScore, Double maxScore, Date startTime, Date endTime);
}
