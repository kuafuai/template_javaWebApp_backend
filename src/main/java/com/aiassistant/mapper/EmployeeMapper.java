package com.aiassistant.mapper;

import com.aiassistant.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    /**
     * 插入一条员工记录
     *
     * @param employee 员工信息
     * @return 插入的员工记录
     */
    Employee insertEmployee(Employee employee);

    /**
     * 查询所有员工记录
     *
     * @return 所有员工记录
     */
    List<Employee> getEmployeeList();

    /**
     * 根据ID查询员工记录
     *
     * @param id 员工ID
     * @return 员工记录
     */
    Employee selectById(Integer id);
}
