package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AssetMapper {
    @Insert("INSERT INTO asset (asset_number, name, specification, purchase_date, purchase_price) " +
            "VALUES (#{assetNumber}, #{name}, #{specification}, #{purchaseDate}, #{purchasePrice})")
    Asset insertAsset(Asset asset);

    @Select("SELECT * FROM asset")
    List<Asset> getAssetList();

    @Select("SELECT * FROM asset WHERE id = #{id}")
    Asset selectById(Integer id);
}
