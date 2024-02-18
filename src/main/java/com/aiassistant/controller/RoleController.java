package com.aiassistant.controller;

import com.aiassistant.model.Role;
import com.aiassistant.service.RoleService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/add")
    public ResultModel<Role> addRole(@RequestBody Role role) {
        Role createdRole = roleService.addRole(role);
        return ResultModel.ofSuccess(createdRole);
    }

    @GetMapping("/{id}")
    public ResultModel<Role> getRoleById(@PathVariable("id") Integer id) {
        Role role = roleService.getRoleById(id);
        return ResultModel.ofSuccess(role);
    }

    @GetMapping("/all")
    public ResultPageModel<Role> getAllRoles() {
        ResultPageModel<Role> roles = roleService.getAllRoles();
        return roles;
    }

    @PutMapping("/update")
    public ResultModel<Role> updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResultModel.ofSuccess();
    }

    @DeleteMapping("/{id}")
    public ResultModel<Role> deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return ResultModel.ofSuccess();
    }
}
