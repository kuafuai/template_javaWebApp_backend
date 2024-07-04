package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class Asset {
    private String assetNumber;
    private String name;
    private String specifications;
    private Date purchaseDate;
    private double purchasePrice;

    // Constructors, getters, and setters
}
