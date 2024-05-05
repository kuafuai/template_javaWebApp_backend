package com.aiassistant.controller;

import com.aiassistant.model.Demo;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/listByType")
    public ResultPageModel<Demo> getDemoListByType(@RequestParam String messageType,
                                                   @RequestParam(defaultValue = "1") Integer pageNo,
                                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        return demoService.getDemoListByType(messageType, pageNo, pageSize);
    }

    @GetMapping("/detail")
    public ResultModel<Demo> getDemoDetail(@RequestParam Integer id) {
        Demo demo = demoService.getById(id);
        if (demo == null) {
            return ResultModel.ofError("Demo not found");
        }
        return ResultModel.ofSuccess(demo);
    }
}
