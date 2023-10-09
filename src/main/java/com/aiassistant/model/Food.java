package com.aiassistant.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Food {
    private int foodId;
    private String name;
    private String image;
    private int categoryId;
    private BigDecimal price;
    private String remark;
    private String other;
}
