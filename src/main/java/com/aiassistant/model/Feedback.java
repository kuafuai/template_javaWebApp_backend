package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {
    private Integer id;
    private String storeName;
    private String feedbackText;
    private String imageUrl;
    private Date createdAt;
}
