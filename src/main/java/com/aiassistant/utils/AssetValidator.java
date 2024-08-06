package com.aiassistant.utils;

import org.apache.commons.lang3.StringUtils;

public class AssetValidator {

    public boolean validateAssetCode(String assetCode) {
        return StringUtils.isNotEmpty(assetCode) && assetCode.matches("^[A-Z0-9]+$");
    }

    public boolean validateAssetName(String assetName) {
        return StringUtils.isNotEmpty(assetName) && assetName.length() <= 100;
    }

    public boolean validateSpecification(String specification) {
        return StringUtils.isNotEmpty(specification) && specification.length() <= 255;
    }

    public boolean validatePurchaseDate(String purchaseDate) {
        // Assuming the format is YYYY-MM-DD
        return StringUtils.isNotEmpty(purchaseDate) && purchaseDate.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public boolean validatePurchasePrice(Float purchasePrice) {
        return purchasePrice != null && purchasePrice >= 0;
    }
}
