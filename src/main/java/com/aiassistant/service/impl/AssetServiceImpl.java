package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetMapper assetMapper;

    @Override
    public ResultModel<Asset> addAsset(Asset asset) {
        Asset createdAsset = assetMapper.insertAsset(asset);
        if (createdAsset != null) {
            return ResultModel.ofSuccess(createdAsset);
        } else {
            return ResultModel.ofError("添加资产失败");
        }
    }

    @Override
    public ResultPageModel<Asset> getAssetList(String assetCode, String name, 
                                                String assetCategory, 
                                                LocalDate startPurchaseDate, 
                                                BigDecimal minPrice, 
                                                BigDecimal maxPrice) {
        List<Asset> assets = assetMapper.getAssetList(assetCode, name, assetCategory, startPurchaseDate, minPrice, maxPrice);
        return ResultPageModel.of(assets);
    }

    @Override
    public Asset getAssetById(Integer id) {
        return assetMapper.selectById(id);
    }
}
