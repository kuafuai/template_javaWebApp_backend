package com.aiassistant.controller;

import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import com.aiassistant.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/updatePassword/{adminId}/{newPassword}")
    public ResultModel<Boolean> updateAdminPassword(@PathVariable Integer adminId, @PathVariable String newPassword) {
        return demoService.updateAdminPassword(adminId, newPassword);
    }

    @GetMapping("/list")
    public ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize) {
        return demoService.getAdminList(pageNo, pageSize);
    }

}
