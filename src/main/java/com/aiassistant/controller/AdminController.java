package com.aiassistant.controller;

import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import com.aiassistant.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/updatePassword/{adminId}/{newPassword}")
    public ResultModel<Boolean> updateAdminPassword(@PathVariable Integer adminId, @PathVariable String newPassword) {
        try {
            if (adminId == null || newPassword == null) {
                throw new IllegalArgumentException("adminId and newPassword cannot be null");
            }
            return demoService.updateAdminPassword(adminId, newPassword);
        } catch (Exception e) {
            return new ResultModel<>(false, e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize) {
        try {
            if (pageNo == null || pageSize == null || pageNo <= 0 || pageSize <= 0) {
                throw new IllegalArgumentException("Invalid pageNo or pageSize");
            }
            return demoService.getAdminList(pageNo, pageSize);
        } catch (Exception e) {
            return new ResultPageModel<>(null, 0, 0, 0, e.getMessage());
        }
    }

}
