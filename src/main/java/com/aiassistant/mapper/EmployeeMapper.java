package com.aiassistant.mapper;

import com.aiassistant.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {
    @Insert("INSERT INTO employee(name, employee_id, hire_date, job_title) VALUES(#{name}, #{employeeId}, #{hireDate}, #{jobTitle})")
    void insertEmployee(Employee employee);

    @Select("SELECT * FROM employee")
    List<Employee> getEmployeeList();

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee selectById(Integer id);
}
