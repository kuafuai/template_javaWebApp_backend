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
        ResultModel<Employee> resultModel = new ResultModel<>();
        if (employee == null || employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Invalid employee information");
            return resultModel;
        }

        Employee existingEmployee = employeeMapper.selectById(employee.getEmployeeId());
        if (existingEmployee != null) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Employee already exists");
            return resultModel;
        }

        employeeMapper.insertEmployee(employee);
        resultModel.setCode(ResultModel.SUCCESS_CODE);
        resultModel.setMessage("Employee added successfully");
        resultModel.setData(employee);
        return resultModel;
    }

    @Override
    public ResultModel<Employee> getEmployeeById(String employeeId) {
        ResultModel<Employee> resultModel = new ResultModel<>();
        if (employeeId == null || employeeId.isEmpty()) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Invalid employee ID");
            return resultModel;
        }

        Employee employee = employeeMapper.selectById(employeeId);
        if (employee == null) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Employee not found");
            return resultModel;
        }

        resultModel.setCode(ResultModel.SUCCESS_CODE);
        resultModel.setMessage("Employee found");
        resultModel.setData(employee);
        return resultModel;
    }

    @Override
    public ResultModel<Employee> updateEmployee(String employeeId, Employee employee) {
        ResultModel<Employee> resultModel = new ResultModel<>();
        if (employeeId == null || employeeId.isEmpty()) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Invalid employee ID");
            return resultModel;
        }

        Employee existingEmployee = employeeMapper.selectById(employeeId);
        if (existingEmployee == null) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Employee not found");
            return resultModel;
        }

        if (employee == null) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Invalid employee information");
            return resultModel;
        }

        employee.setEmployeeId(employeeId);
        employeeMapper.updateEmployee(employee);
        resultModel.setCode(ResultModel.SUCCESS_CODE);
        resultModel.setMessage("Employee updated successfully");
        resultModel.setData(employee);
        return resultModel;
    }

    @Override
    public ResultModel<String> deleteEmployee(String employeeId) {
        ResultModel<String> resultModel = new ResultModel<>();
        if (employeeId == null || employeeId.isEmpty()) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Invalid employee ID");
            return resultModel;
        }

        Employee existingEmployee = employeeMapper.selectById(employeeId);
        if (existingEmployee == null) {
            resultModel.setCode(ResultModel.FAIL_CODE);
            resultModel.setMessage("Employee not found");
            return resultModel;
        }

        employeeMapper.deleteEmployee(employeeId);
        resultModel.setCode(ResultModel.SUCCESS_CODE);
        resultModel.setMessage("Employee deleted successfully");
        resultModel.setData(employeeId);
        return resultModel;
    }
}
