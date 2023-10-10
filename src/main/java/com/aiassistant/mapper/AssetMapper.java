package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AssetMapper {
    @Insert("INSERT INTO asset(asset_id, name, specification, purchase_date, purchase_price) " +
            "VALUES(#{assetId}, #{name}, #{specification}, #{purchaseDate}, #{purchasePrice})")
    void insertAsset(Asset asset);

    /**
     * 根据资产Id查询资产信息
     *
     * @param assetId
     * @return
     */
    @Select("SELECT * FROM asset WHERE asset_id = #{assetId}")
    Asset selectById(String assetId);

    @Update("UPDATE asset SET name = #{name}, specification = #{specification}, " +
            "purchase_date = #{purchaseDate}, purchase_price = #{purchasePrice} WHERE asset_id = #{assetId}")
    void updateAsset(Asset asset);

    @Delete("DELETE FROM asset WHERE asset_id = #{assetId}")
    void deleteById(String assetId);
}
