package com.aiassistant.controller;

import com.aiassistant.model.Demo;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "DemoController")
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/addDemo")
    @ApiOperation(value = "Demo add")
    public ResultModel addDemo(@RequestBody Demo demo) {
        return demoService.addDemo(demo);
    }

    @GetMapping("/getDemoList")
    @ApiOperation(value = "Get Demo list")
    public ResultPageModel<Demo> getDemoList() {
        return demoService.getDemoList();
    }
}
