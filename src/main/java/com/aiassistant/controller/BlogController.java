package com.aiassistant.controller;

import com.aiassistant.utils.ResultModel;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/addBlog")
    public ResultModel<String> addBlog(@RequestBody String content) {
        if (StringUtils.isBlank(content)) {
            return ResultModel.ofError("Blog content cannot be empty");
        }

        if (content.length() > 200) {
            return ResultModel.ofError("Blog content cannot exceed 200 characters");
        }

        blogService.saveBlog(content);

        return ResultModel.ofSuccess("Blog added successfully");
    }
}
