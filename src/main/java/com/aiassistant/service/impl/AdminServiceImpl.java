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

    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public ResultModel<Boolean> updateAdminPassword(Integer adminId, String newPassword) {
        try {
            adminMapper.updateAdminPassword(adminId, newPassword);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update admin password", e);
        }
    }

    @Override
    public ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize) {
        try {
            int totalRecords = adminMapper.getAdminList().size();
            int totalPage = (int) Math.ceil((double) totalRecords / pageSize);
            int firstIndex = (pageNo - 1) * pageSize;
            int lastIndex = Math.min(firstIndex + pageSize, totalRecords);

            ResultPageModel<Admin> resultPageModel = ResultPageModel.of(adminMapper.getAdminList());
            resultPageModel.setTotalRecords(totalRecords);
            resultPageModel.setPageNo(pageNo);
            resultPageModel.setPageSize(pageSize);
            resultPageModel.setTotalPage(totalPage);
            resultPageModel.setList(resultPageModel.getList().subList(firstIndex, lastIndex));

            return resultPageModel;
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get admin list", e);
        }
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        try {
            return adminMapper.selectById(adminId);
        } catch (Exception e) {
            return null;
        }
    }
}
