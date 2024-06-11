package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import com.aiassistant.model.Admin;

public interface DemoService {
    ResultModel<Boolean> updateAdminPassword(Integer adminId, String newPassword);
    ResultPageModel<Admin> getAdminList(Integer pageNo, Integer pageSize);
}
