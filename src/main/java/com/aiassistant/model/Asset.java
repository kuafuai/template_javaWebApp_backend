package com.aiassistant.model;

import lombok.Data;

@Data
public class Asset {
    private String assetCode;
    private String assetName;
    private String specification;
    private String purchaseDate;
    private Float purchasePrice;
    private Integer id;
}
