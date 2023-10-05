package com.aiassistant.service;

import com.aiassistant.model.Employee;
import com.aiassistant.utils.ResultModel;

public interface EmployeeService {
    ResultModel<Employee> addEmployee(Employee employee);
    ResultModel<Employee> getEmployeeById(String employeeId);
    ResultModel<Employee> updateEmployee(String employeeId, Employee employee);
    ResultModel<String> deleteEmployee(String employeeId);
}
