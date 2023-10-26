package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class Store {
    private Integer id;
    private String name;
    private String address;
    private Date timestamp;
}
