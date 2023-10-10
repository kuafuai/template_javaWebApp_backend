package com.aiassistant.controller;

import com.aiassistant.model.Employee;
import com.aiassistant.service.EmployeeService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResultModel addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/list")
    public ResultPageModel<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public ResultModel getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.getById(id);
        if (employee != null) {
            return ResultModel.ofSuccess(employee);
        } else {
            return ResultModel.ofError("Employee not found");
        }
    }

    @PutMapping("/{id}")
    public ResultModel updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        ResultModel result = employeeService.updateEmployee(id, employee);
        if (result.isSuccess()) {
            return ResultModel.ofSuccess();
        } else {
            return ResultModel.ofError(result.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResultModel deleteEmployee(@PathVariable Integer id) {
        ResultModel result = employeeService.deleteEmployee(id);
        if (result.isSuccess()) {
            return ResultModel.ofSuccess();
        } else {
            return ResultModel.ofError(result.getMessage());
        }
    }
}
