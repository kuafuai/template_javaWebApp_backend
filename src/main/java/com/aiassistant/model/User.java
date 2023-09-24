package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name;
    private String jobNumber;
    private Date hireDate;
    private String position;
}