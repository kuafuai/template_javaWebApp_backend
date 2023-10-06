package com.aiassistant.service;

import com.aiassistant.model.Employee;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface EmployeeService {
    // 业务逻辑层--employee Service
    ResultModel<Employee> addEmployee(Employee employee);

    ResultPageModel<Employee> getEmployeeList();

    Employee getById(Integer id);
}