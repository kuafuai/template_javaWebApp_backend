package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;

    @Autowired
    public AssetServiceImpl(AssetMapper assetMapper) {
        this.assetMapper = assetMapper;
    }

    @Override
    public ResultModel<Asset> addAsset(Asset asset) {
        // 校验必填字段
        if (asset.getAssetId() == null || asset.getName() == null || asset.getSpecification() == null ||
                asset.getPurchaseDate() == null || asset.getPurchasePrice() == null) {
            return ResultModel.ofError("Missing required fields");
        }

        // 插入资产信息
        assetMapper.insertAsset(asset);

        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultModel<Asset> getAssetById(String assetId) {
        Asset asset = assetMapper.selectById(assetId);
        if (asset == null) {
            return ResultModel.ofError("Asset not found");
        }
        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultModel<Asset> updateAsset(Asset asset) {
        // 校验必填字段
        if (asset.getAssetId() == null || asset.getName() == null || asset.getSpecification() == null ||
                asset.getPurchaseDate() == null || asset.getPurchasePrice() == null) {
            return ResultModel.ofError("Missing required fields");
        }

        // 更新资产信息
        assetMapper.updateAsset(asset);

        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultModel<Asset> deleteAssetById(String assetId) {
        assetMapper.deleteById(assetId);
        return ResultModel.ofSuccess();
    }
}
