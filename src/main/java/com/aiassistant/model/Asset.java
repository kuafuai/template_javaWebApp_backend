package com.aiassistant.model;

import lombok.Data;

@Data
public class Asset {
    private String assetId;
    private String assetNumber;
    private String name;
    private String specifications;
    private String purchaseDate;
    private Double purchasePrice;
}
