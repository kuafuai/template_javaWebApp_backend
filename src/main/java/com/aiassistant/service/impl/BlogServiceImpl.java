package com.aiassistant.service.impl;

import com.aiassistant.mapper.BlogMapper;
import com.aiassistant.service.BlogService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public ResultModel<String> addBlog(String content) {
        // Insert the blog content into the database
        blogMapper.insertBlog(content);

        // Return the unique identifier of the inserted blog
        return ResultModel.ofSuccess();
    }
}
