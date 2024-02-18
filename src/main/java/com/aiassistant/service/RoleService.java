package com.aiassistant.service;

import com.aiassistant.model.Role;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface RoleService {
    ResultModel<Role> addRole(Role role);

    ResultModel<Role> getRoleById(Integer id);

    ResultPageModel<Role> getAllRoles();

    ResultModel<Role> updateRole(Role role);

    ResultModel<Role> deleteRole(Integer id);
}
