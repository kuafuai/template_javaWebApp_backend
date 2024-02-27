package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;

public interface BlogService {
    ResultModel<String> addBlog(String content);
}
