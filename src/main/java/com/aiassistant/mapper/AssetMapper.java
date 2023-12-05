package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetMapper {
    @Insert("INSERT INTO asset (name, type, purchase_date, price) VALUES (#{name}, #{type}, #{purchaseDate}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @SelectKey(statement = "SELECT last_insert_rowid()", keyProperty = "id", before = false, resultType = Integer.class)
    Asset insertAsset(Asset asset);
}
