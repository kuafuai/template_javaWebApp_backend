package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;

    @Autowired
    public AssetServiceImpl(AssetMapper assetMapper) {
        this.assetMapper = assetMapper;
    }

    @Override
    @Transactional
    public ResultModel<Asset> addAsset(Asset asset) {
        // 校验请求参数的完整性和有效性
        if (asset.getAssetNo() == null || asset.getPurchaseDate() == null) {
            return ResultModel.ofError("Invalid request parameters");
        }

        // 检查资产编号是否唯一
        Asset existingAsset = assetMapper.getByAssetNo(asset.getAssetNo());
        if (existingAsset != null) {
            return ResultModel.ofError("Asset number already exists");
        }

        // 检查采购日期是否合法
        // TODO: Implement the logic to check if the purchase date is valid

        // 将请求参数存储到Asset表中，并进行事务管理，以确保数据的一致性和完整性
        assetMapper.insertAsset(asset);

        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultPageModel<Asset> getAssetList() {
        // 获取资产列表
        List<Asset> assetList = assetMapper.getAssetList();

        return ResultPageModel.of(assetList);
    }

    @Override
    public Asset getById(Integer id) {
        // 根据ID查询资产信息
        return assetMapper.getById(id);
    }
}
