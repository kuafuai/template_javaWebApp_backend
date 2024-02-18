package com.aiassistant.service.impl;

import com.aiassistant.mapper.RoleMapper;
import com.aiassistant.model.Role;
import com.aiassistant.service.RoleService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public ResultModel<Role> addRole(Role role) {
        try {
            roleMapper.insertRole(role);
            return ResultModel.ofSuccess(role);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add role", e);
        }
    }

    @Override
    public ResultModel<Role> getRoleById(Integer id) {
        try {
            Role role = roleMapper.selectById(id);
            if (role != null) {
                return ResultModel.ofSuccess(role);
            } else {
                return ResultModel.ofError("Role not found");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get role by id", e);
        }
    }

    @Override
    public ResultPageModel<Role> getAllRoles() {
        try {
            List<Role> roleList = roleMapper.getRoleList();
            return ResultPageModel.of(roleList);
        } catch (Exception e) {
            return ResultPageModel.of(null);
        }
    }

    @Override
    public ResultModel<Role> updateRole(Role role) {
        try {
            roleMapper.updateRole(role);
            return ResultModel.ofSuccess(role);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update role", e);
        }
    }

    @Override
    public ResultModel<Role> deleteRole(Integer id) {
        try {
            Role role = roleMapper.selectById(id);
            if (role != null) {
                roleMapper.deleteRole(id);
                return ResultModel.ofSuccess(role);
            } else {
                return ResultModel.ofError("Role not found");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to delete role", e);
        }
    }
}
