package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AssetMapper {
    
    @Insert("INSERT INTO assets(asset_id, name, specifications, purchase_date, purchase_price, asset_category) " +
            "VALUES(#{assetId}, #{name}, #{specifications}, #{purchaseDate}, #{purchasePrice}, #{assetCategory})")
    Asset insertAsset(Asset asset);

    @Select("SELECT * FROM assets WHERE asset_id = #{assetId}")
    Asset selectByAssetId(String assetId);
}
