package com.aiassistant.service;

import com.aiassistant.mapper.AdminMapper;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public ResultModel updatePassword(Integer adminId, String newPassword) {
        int rows = adminMapper.updatePassword(adminId, newPassword);
        if (rows > 0) {
            return ResultModel.success("Password updated successfully");
        } else {
            return ResultModel.error("Failed to update password");
        }
    }

    public ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize) {
        int total = adminMapper.getAdminCount();
        int offset = (pageNo - 1) * pageSize;
        List<Admin> adminList = adminMapper.getAdminList(offset, pageSize);
        return new ResultPageModel<>(adminList, pageNo, pageSize, total);
    }
}
