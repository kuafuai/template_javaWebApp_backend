package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private String name;
    private String employeeId;
    private Date hireDate;
    private String jobTitle;
}
