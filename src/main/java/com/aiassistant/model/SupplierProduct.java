package com.aiassistant.model;

import java.util.Date;
import lombok.Data;

@Data
public class SupplierProduct {
    private String productModel;
    private String deliveryTime;
    private Double productPrice;
    private Integer deliverableQuantity;
    private String tradingCounterparty;
    private Double advancePaymentRatio;
}
