package com.aiassistant.service;

import com.aiassistant.model.Asset;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

import java.time.LocalDate;
import java.math.BigDecimal;

public interface AssetService {
    ResultModel<Asset> addAsset(Asset asset);
    
    ResultPageModel<Asset> getAssetList(String assetCode, String name, String assetCategory, LocalDate purchaseDate, BigDecimal minPrice, BigDecimal maxPrice);
    
    Asset getAssetById(Integer id);
}
