package com.aiassistant.model;

import java.util.Date;

public class SupplierProduct {
    private String productModel;
    private Date deliveryTime;
    private Double productPrice;
    private Integer deliverableQuantity;
    private String tradingCounterparty;
    private Double advancePaymentRatio;

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getDeliverableQuantity() {
        return deliverableQuantity;
    }

    public void setDeliverableQuantity(Integer deliverableQuantity) {
        this.deliverableQuantity = deliverableQuantity;
    }

    public String getTradingCounterparty() {
        return tradingCounterparty;
    }

    public void setTradingCounterparty(String tradingCounterparty) {
        this.tradingCounterparty = tradingCounterparty;
    }

    public Double getAdvancePaymentRatio() {
        return advancePaymentRatio;
    }

    public void setAdvancePaymentRatio(Double advancePaymentRatio) {
        this.advancePaymentRatio = advancePaymentRatio;
    }
}
