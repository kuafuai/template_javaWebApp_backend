package com.aiassistant.service;

import com.aiassistant.model.Asset;
import com.aiassistant.utils.ResultModel;

public interface AssetService {
    ResultModel<Asset> addAsset(Asset asset);
}
