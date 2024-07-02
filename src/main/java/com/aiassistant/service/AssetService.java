package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import com.aiassistant.model.AssetRegistrationRequest;
import com.aiassistant.model.AssetRegistrationResponse;
import com.aiassistant.model.AssetRegistrationQuery;

public interface AssetService {
    
    ResultModel<AssetRegistrationResponse> addAssetRegistration(AssetRegistrationRequest request);

    ResultModel<AssetRegistrationResponse> editAssetRegistration(String assetId, AssetRegistrationRequest request);

    ResultModel<String> deleteAssetRegistration(String assetId);

    ResultModel<AssetRegistrationResponse> getAssetRegistrationById(String assetId);

    ResultPageModel<AssetRegistrationResponse> getAssetRegistrationListByCondition(AssetRegistrationQuery query);
}
