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

    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public ResultModel<Employee> addEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
        return new ResultModel<>(employee);
    }

    @Override
    public ResultPageModel<Employee> getEmployeeList() {
        return new ResultPageModel<>(employeeMapper.getEmployeeList());
    }

    @Override
    public Employee getById(Integer id) {
        return employeeMapper.selectById(id);
    }
}
