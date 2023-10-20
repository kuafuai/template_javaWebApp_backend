package com.aiassistant.model;

import java.math.BigDecimal;

public class Food {
    private int foodId;
    private String foodName;
    private String foodImage;
    private int foodCategoryId;
    private BigDecimal foodPrice;
    private String foodRemark;
    private String otherParams;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public int getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(int foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodRemark() {
        return foodRemark;
    }

    public void setFoodRemark(String foodRemark) {
        this.foodRemark = foodRemark;
    }

    public String getOtherParams() {
        return otherParams;
    }

    public void setOtherParams(String otherParams) {
        this.otherParams = otherParams;
    }
}
