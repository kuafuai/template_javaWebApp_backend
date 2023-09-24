package com.aiassistant.model;

import java.math.BigDecimal;
import java.util.Date;

public class Asset {
    private String assetId;
    private String name;
    private String specification;
    private Date purchaseDate;
    private BigDecimal purchasePrice;
    private Attachment attachment;

    public Asset(String assetId, String name, String specification, Date purchaseDate, BigDecimal purchasePrice, Attachment attachment) {
        this.assetId = assetId;
        this.name = name;
        this.specification = specification;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.attachment = attachment;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        if (specification != null && !specification.isEmpty()) {
            this.specification = specification;
        }
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        if (purchasePrice != null && purchasePrice.compareTo(BigDecimal.ZERO) > 0) {
            this.purchasePrice = purchasePrice;
        }
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}