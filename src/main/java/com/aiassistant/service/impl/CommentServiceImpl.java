package com.aiassistant.service.impl;

import com.aiassistant.mapper.CommentMapper;
import com.aiassistant.model.Comment;
import com.aiassistant.service.CommentService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public ResultModel<Comment> addComment(Comment comment) {
        try {
            int result = commentMapper.addComment(comment);
            if (result > 0) {
                return ResultModel.ofSuccess(comment);
            } else {
                return ResultModel.ofError("Failed to add comment");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add comment", e);
        }
    }

    @Override
    public ResultPageModel<Comment> getCommentList(Double latitude, Double longitude, Date startDate, Date endDate) {
        try {
            List<Comment> commentList = commentMapper.getCommentList(latitude, longitude, startDate, endDate);
            return ResultPageModel.ofSuccess(commentList);
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get comment list", e);
        }
    }
}
