package com.aiassistant.service.impl;

import com.aiassistant.mapper.EmployeeMapper;
import com.aiassistant.model.Employee;
import com.aiassistant.service.EmployeeService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
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
        try {
            employeeMapper.insertEmployee(employee);
            return new ResultModel<>(employee);
        } catch (Exception e) {
            return new ResultModel<>(ResultModel.FAIL, "Failed to add employee");
        }
    }

    @Override
    public ResultPageModel<Employee> getEmployeeList() {
        try {
            return new ResultPageModel<>(employeeMapper.getEmployeeList());
        } catch (Exception e) {
            return new ResultPageModel<>(ResultModel.FAIL, "Failed to get employee list");
        }
    }

    @Override
    public ResultModel<Employee> updateEmployee(String employeeId, Employee employee) {
        try {
            Employee existingEmployee = employeeMapper.selectById(employeeId);
            if (existingEmployee == null) {
                return new ResultModel<>(ResultModel.FAIL, "Employee not found");
            }
            employee.setEmployeeId(employeeId);
            employeeMapper.updateEmployee(employee);
            return new ResultModel<>(employee);
        } catch (Exception e) {
            return new ResultModel<>(ResultModel.FAIL, "Failed to update employee");
        }
    }

    @Override
    public ResultModel deleteEmployee(String employeeId) {
        try {
            Employee existingEmployee = employeeMapper.selectById(employeeId);
            if (existingEmployee == null) {
                return new ResultModel<>(ResultModel.FAIL, "Employee not found");
            }
            employeeMapper.deleteEmployee(employeeId);
            return new ResultModel<>();
        } catch (Exception e) {
            return new ResultModel<>(ResultModel.FAIL, "Failed to delete employee");
        }
    }
}
