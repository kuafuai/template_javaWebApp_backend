package com.aiassistant.service.impl;

import com.aiassistant.mapper.EmployeeMapper;
import com.aiassistant.model.Employee;
import com.aiassistant.service.EmployeeService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public ResultModel<Employee> addEmployee(Employee employee) {
        // 验证员工工号的唯一性和格式是否符合要求（8位数字唯一）
        if (!isValidEmployeeId(employee.getEmployeeId())) {
            return ResultModel.ofError("Invalid employee ID");
        }

        try {
            // 将员工信息保存到数据库中
            employeeMapper.insertEmployee(employee);
            return ResultModel.ofSuccess(employee);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add employee", e);
        }
    }

    @Override
    public ResultModel<Employee> getEmployeeById(String employeeId) {
        try {
            // 根据工号从数据库中查询员工信息
            Employee employee = employeeMapper.selectById(employeeId);
            if (employee != null) {
                return ResultModel.ofSuccess(employee);
            } else {
                return ResultModel.ofError("Employee not found");
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get employee", e);
        }
    }

    @Override
    public ResultModel<Employee> updateEmployee(Employee employee) {
        // 验证员工工号的唯一性和格式是否符合要求（8位数字唯一）
        if (!isValidEmployeeId(employee.getEmployeeId())) {
            return ResultModel.ofError("Invalid employee ID");
        }

        try {
            // 根据工号更新数据库中的员工信息
            employeeMapper.updateEmployee(employee);
            return ResultModel.ofSuccess(employee);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update employee", e);
        }
    }

    @Override
    public ResultModel<Employee> deleteEmployeeById(String employeeId) {
        try {
            // 根据工号从数据库中删除员工信息
            employeeMapper.deleteById(employeeId);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to delete employee", e);
        }
    }

    private boolean isValidEmployeeId(String employeeId) {
        // 验证员工工号的唯一性和格式是否符合要求（8位数字唯一）
        return employeeId.matches("\\d{8}");
    }
}
