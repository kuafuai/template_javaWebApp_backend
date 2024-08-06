package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.AssetValidator;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;

    @Autowired
    public AssetServiceImpl(AssetMapper assetMapper) {
        this.assetMapper = assetMapper;
    }

    @Override
    public ResultModel<Asset> addAsset(Asset asset) {
        AssetValidator validator = new AssetValidator();
        if (!validator.validateAssetCode(asset.getAssetCode())) {
            return ResultModel.ofError("Invalid asset code.");
        }
        if (!validator.validateAssetName(asset.getAssetName())) {
            return ResultModel.ofError("Invalid asset name.");
        }
        if (!validator.validateSpecification(asset.getSpecification())) {
            return ResultModel.ofError("Invalid specification.");
        }
        if (!validator.validatePurchaseDate(asset.getPurchaseDate())) {
            return ResultModel.ofError("Invalid purchase date.");
        }
        if (!validator.validatePurchasePrice(asset.getPurchasePrice())) {
            return ResultModel.ofError("Invalid purchase price.");
        }

        assetMapper.insertAsset(asset);
        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultPageModel<Asset> getAssetList() {
        List<Asset> assets = assetMapper.getAssetList();
        ResultPageModel<Asset> resultPageModel = ResultPageModel.of(assets);
        return resultPageModel;
    }
}
