package com.aiassistant.service;

import com.aiassistant.model.Employee;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface EmployeeService {
    ResultModel<Employee> addEmployee(Employee employee);

    ResultPageModel<Employee> getEmployeeList();

    ResultModel<Employee> updateEmployee(String employeeId, Employee employee);

    ResultModel<Employee> deleteEmployee(String employeeId);
}
