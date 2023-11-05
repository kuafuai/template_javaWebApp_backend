package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
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
        try {
            assetMapper.insertAsset(asset);
            return ResultModel.ofSuccess(asset);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add asset", e);
        }
    }

    @Override
    public ResultPageModel<Asset> getAssetList() {
        try {
            ResultPageModel<Asset> resultPageModel = new ResultPageModel<>();
            resultPageModel.setList(assetMapper.getAssetList());
            resultPageModel.setTotalRecords(resultPageModel.getList().size());
            return resultPageModel;
        } catch (Exception e) {
            return ResultPageModel.ofResult(0, "Failed to get asset list", null, e);
        }
    }

    @Override
    public Asset getById(Integer id) {
        return assetMapper.selectById(id);
    }
}
