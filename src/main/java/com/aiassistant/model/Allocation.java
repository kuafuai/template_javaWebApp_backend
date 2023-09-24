package com.aiassistant.model;

import java.util.Date;

public class Allocation {
    private String allocationId;
    private String employeeId;
    private String assetId;
    private Date allocationDate;

    public Allocation(String allocationId, String employeeId, String assetId, Date allocationDate) {
        this.allocationId = allocationId;
        this.employeeId = employeeId;
        this.assetId = assetId;
        this.allocationDate = allocationDate;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }
}