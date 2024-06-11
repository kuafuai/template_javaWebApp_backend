package com.aiassistant.controller;

import com.aiassistant.service.AdminService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/updatePassword/{adminId}")
    public ResultModel updatePassword(@PathVariable Integer adminId, @RequestParam String newPassword) {
        return adminService.updatePassword(adminId, newPassword);
    }

    @GetMapping("/getAdminList")
    public ResultPageModel<Admin> getAdminList(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return adminService.getAdminList(pageNo, pageSize);
    }
}
