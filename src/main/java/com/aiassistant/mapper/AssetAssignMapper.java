package com.aiassistant.mapper;

import com.aiassistant.model.AssetAssign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssetAssignMapper {
    @Insert("INSERT INTO asset_assign (asset_id, employee_id, assign_date) VALUES (#{assetId}, #{employeeId}, #{assignDate})")
    void insertAssetAssign(AssetAssign assetAssign);
}
