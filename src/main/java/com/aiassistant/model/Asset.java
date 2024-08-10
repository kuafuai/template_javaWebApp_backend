package com.aiassistant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private String assetCode;
    private String name;
    private String specification;
    private LocalDate purchaseDate;
    private BigDecimal purchasePrice;
    private String assetCategory;
    private String department;
    private String status;
    private String auditStatus;
}
