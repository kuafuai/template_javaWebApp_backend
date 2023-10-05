package com.aiassistant.mapper;

import com.aiassistant.model.Employee;
import java.util.List;

public interface EmployeeMapper {
    Employee insertEmployee(Employee employee);
    List<Employee> getEmployeeList();
    Employee selectById(String employeeId);
}
