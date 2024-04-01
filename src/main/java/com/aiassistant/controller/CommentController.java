package com.aiassistant.controller;

import com.aiassistant.model.Comment;
import com.aiassistant.service.CommentService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResultModel<Comment> addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PostMapping("/list")
    public ResultPageModel<Comment> getCommentList(Double minScore, Double maxScore, Date startTime, Date endTime) {
        return commentService.getCommentList(minScore, maxScore, startTime, endTime);
    }
}
