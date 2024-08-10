package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetMapper {
    
    @Insert("INSERT INTO assets(asset_code, name, specification, purchase_date, purchase_price, asset_category, department, status, audit_status) " +
            "VALUES(#{assetCode}, #{name}, #{specification}, #{purchaseDate}, #{purchasePrice}, #{assetCategory}, #{department}, #{status}, #{auditStatus})")
    Asset insertAsset(Asset asset);

    @Select("<script>" +
            "SELECT * FROM assets " +
            "<where>" +
            "<if test='assetCode != null'>AND asset_code = #{assetCode}</if>" +
            "<if test='name != null'>AND name = #{name}</if>" +
            "<if test='specification != null'>AND specification = #{specification}</if>" +
            "<if test='purchaseDate != null'>AND purchase_date = #{purchaseDate}</if>" +
            "<if test='minPrice != null'>AND purchase_price &gt;= #{minPrice}</if>" +
            "<if test='maxPrice != null'>AND purchase_price &lt;= #{maxPrice}</if>" +
            "</where>" +
            "</script>")
    List<Asset> getAssetList(@Param("assetCode") String assetCode,
                              @Param("name") String name,
                              @Param("specification") String specification,
                              @Param("purchaseDate") LocalDate purchaseDate,
                              @Param("minPrice") BigDecimal minPrice,
                              @Param("maxPrice") BigDecimal maxPrice);

    @Select("SELECT * FROM assets WHERE id = #{id}")
    Asset selectById(@Param("id") Integer id);
}
