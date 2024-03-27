package com.aiassistant.service;

import com.aiassistant.model.Asset;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface AssetService {
    ResultModel<Asset> addAsset(Asset asset);
    ResultPageModel<Asset> getAssetList();
    Asset getById(Integer id);
}
