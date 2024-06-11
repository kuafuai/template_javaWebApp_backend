package com.aiassistant.service;

import com.aiassistant.model.Admin;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface AdminService {
    ResultModel updatePassword(Integer adminId, String oldPassword, String newPassword);

    ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize);
}
