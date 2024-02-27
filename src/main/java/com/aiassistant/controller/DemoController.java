package com.aiassistant.controller;

import com.aiassistant.model.Demo;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/addBlog")
    public ResultModel<String> addBlog(@RequestBody String content) {
        // Validate the length of the blog content
        if (content.length() > 200) {
            return ResultModel.ofError("Blog content exceeds the maximum length of 200 characters");
        }

        // Save the blog content
        Demo demo = new Demo();
        demo.setContent(content);
        ResultModel<Demo> result = demoService.addDemo(demo);

        if (result.getCode() == 200) {
            return ResultModel.ofSuccess("Blog added successfully");
        } else {
            return ResultModel.ofError("Failed to add blog");
        }
    }

    @PostMapping("/getBlogList")
    public ResultPageModel<Demo> getBlogList() {
        return demoService.getDemoList();
    }
}
