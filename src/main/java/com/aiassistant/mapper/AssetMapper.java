package com.aiassistant.mapper;

import com.aiassistant.model.Asset;

public interface AssetMapper {
    int insertAsset(Asset asset);
    
    Asset getAssetById(int id);
    
    int updateAsset(Asset asset);
    
    int deleteAsset(int id);
}