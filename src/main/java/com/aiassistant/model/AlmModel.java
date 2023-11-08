package com.aiassistant.model;

import lombok.Data;

@Data
public class AlmModel {
    private Integer id;
    private String uniqueKey;
    private String dueDate;
    private String exportTime;
    private String message;
    private int status;
}
