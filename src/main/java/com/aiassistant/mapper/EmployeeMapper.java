package com.aiassistant.mapper;

import com.aiassistant.model.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Insert("INSERT INTO employee(name, employee_id, hire_date, job_title) VALUES(#{name}, #{employeeId}, #{hireDate}, #{jobTitle})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(Employee employee);

    /**
     * 根据员工编号查询员工信息
     *
     * @param employeeId
     * @return
     */
    @Select("SELECT * FROM employee WHERE employee_id = #{employeeId}")
    Employee selectById(String employeeId);

    @Update("UPDATE employee SET name = #{name}, hire_date = #{hireDate}, job_title = #{jobTitle} WHERE employee_id = #{employeeId}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE employee_id = #{employeeId}")
    void deleteById(String employeeId);
}
