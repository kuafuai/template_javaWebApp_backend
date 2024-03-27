package com.aiassistant.mapper;

import com.aiassistant.model.Asset;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetMapper {
    Asset insertAsset(Asset asset);

    List<Asset> getAssetList();

    Asset selectById(Integer id);
}
