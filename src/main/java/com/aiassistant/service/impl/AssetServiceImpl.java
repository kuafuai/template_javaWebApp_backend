package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetMapper assetMapper;

    @Override
    public ResultModel addAsset(Asset asset) {
        ResultModel result = new ResultModel();

        // 验证资产唯一性
        Asset existingAsset = assetMapper.selectByAssetId(asset.getAssetId());
        if (existingAsset != null) {
            result.setSuccess(false);
            result.setMessage("资产ID已存在，请使用其他资产ID.");
            return result;
        }

        // 采购日期检查
        if (asset.getPurchaseDate() == null || asset.getPurchaseDate().after(new Date())) {
            result.setSuccess(false);
            result.setMessage("采购日期无效，请输入正确的采购日期.");
            return result;
        }

        // 添加资产
        assetMapper.insertAsset(asset);

        // 计算折旧
        Float depreciation = calculateDepreciation(asset.getPurchasePrice());
        asset.setPurchasePrice(depreciation);

        result.setSuccess(true);
        result.setMessage("资产添加成功.");
        result.setData(asset);
        return result;
    }

    private Float calculateDepreciation(Float purchasePrice) {
        // 简单的折旧计算示例：假设每年折旧10%
        return purchasePrice * 0.9f;
    }
}
