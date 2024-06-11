package com.aiassistant.service.impl;

import com.aiassistant.mapper.AdminMapper;
import com.aiassistant.model.Admin;
import com.aiassistant.service.AdminService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultModel updatePassword(Integer adminId, String oldPassword, String newPassword) {
        Admin admin = adminMapper.selectById(adminId);
        if (admin == null) {
            return ResultModel.ofError("Admin not found");
        }
        if (!admin.getPassword().equals(oldPassword)) {
            return ResultModel.ofError("Old password is incorrect");
        }
        admin.setPassword(newPassword);
        adminMapper.updatePassword(adminId, newPassword);
        return ResultModel.ofSuccess();
    }

    @Override
    public ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize) {
        Integer firstIndex = (pageNo - 1) * pageSize;
        Integer totalRecords = adminMapper.getAdminCount();
        Integer totalPage = (totalRecords + pageSize - 1) / pageSize;
        if (pageNo > totalPage) {
            pageNo = totalPage;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        ResultPageModel<Admin> resultPageModel = new ResultPageModel<>();
        resultPageModel.setTotalRecords(totalRecords);
        resultPageModel.setPageNo(pageNo);
        resultPageModel.setPageSize(pageSize);
        resultPageModel.setTotalPage(totalPage);
        resultPageModel.setList(adminMapper.getAdminList(firstIndex, pageSize));
        return resultPageModel;
    }
}
