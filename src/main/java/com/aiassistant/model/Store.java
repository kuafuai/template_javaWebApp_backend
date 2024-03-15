package com.aiassistant.model;

import org.apache.commons.lang3.StringUtils;

public class Store {
    private String storeName;
    private String storeAddress;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(storeName) && StringUtils.isNotBlank(storeAddress);
    }
}
