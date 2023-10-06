package com.aiassistant.controller;

import com.aiassistant.model.Employee;
import com.aiassistant.service.EmployeeService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * 添加一条员工记录
     *
     * @param employee 员工信息
     * @return 添加结果
     */
    public ResultModel<Employee> addEmployee(Employee employee) {
        // TODO: Implement this method
        return null;
    }

    /**
     * 获取所有员工记录
     *
     * @return 所有员工记录
     */
    public ResultPageModel<Employee> getEmployeeList() {
        // TODO: Implement this method
        return null;
    }

    /**
     * 处理GET请求，获取所有员工信息
     *
     * @return 所有员工信息
     */
    @GetMapping("/employees")
    public ResultPageModel<Employee> getAllEmployees() {
        return employeeService.getEmployeeList();
    }
}
