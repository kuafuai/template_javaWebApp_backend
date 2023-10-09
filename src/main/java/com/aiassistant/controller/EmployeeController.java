package com.aiassistant.controller;

import com.aiassistant.model.Employee;
import com.aiassistant.service.EmployeeService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器层--员工管理
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResultModel<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResultModel<Employee> getEmployeeById(@PathVariable("id") String id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update")
    public ResultModel<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResultModel<Employee> deleteEmployeeById(@PathVariable("id") String id) {
        return employeeService.deleteEmployeeById(id);
    }
}
