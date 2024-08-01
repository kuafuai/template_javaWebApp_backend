package com.aiassistant.model;

import lombok.Data;

import java.util.Date;

@Data
public class Asset {
    private String assetId;
    private String name;
    private String specifications;
    private Date purchaseDate;
    private Float purchasePrice;
    private String assetCategory;
}
