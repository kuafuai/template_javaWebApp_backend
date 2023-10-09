package com.aiassistant.service;

import com.aiassistant.model.Employee;
import com.aiassistant.utils.ResultModel;

public interface EmployeeService {
    ResultModel<Employee> addEmployee(Employee employee);

    ResultModel<Employee> getEmployeeById(String employeeId);

    ResultModel<Employee> updateEmployee(Employee employee);

    ResultModel<Employee> deleteEmployeeById(String employeeId);
}
