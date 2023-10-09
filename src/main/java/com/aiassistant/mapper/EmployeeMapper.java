package com.aiassistant.mapper;

import com.aiassistant.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee insertEmployee(Employee employee);

    List<Employee> getEmployeeList();

    Employee selectById(String employeeId);
}
