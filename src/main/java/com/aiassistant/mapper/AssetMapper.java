package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetMapper {
    
    @Insert("INSERT INTO asset(asset_code, asset_name, specification, purchase_date, purchase_price) VALUES(#{assetCode}, #{assetName}, #{specification}, #{purchaseDate}, #{purchasePrice})")
    Asset insertAsset(Asset asset);

    @Select("SELECT * FROM asset")
    List<Asset> getAssetList();

    @Select("SELECT * FROM asset WHERE asset_code = #{assetCode}")
    Asset selectByCode(String assetCode);
}
