package com.aiassistant.controller;

import com.aiassistant.model.AssetRegistrationRequest;
import com.aiassistant.model.AssetRegistrationResponse;
import com.aiassistant.model.AssetRegistrationQuery;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping("/add")
    public ResultModel<AssetRegistrationResponse> addAssetRegistration(@RequestBody AssetRegistrationRequest request) {
        return assetService.addAssetRegistration(request);
    }

    @PutMapping("/edit/{assetId}")
    public ResultModel<AssetRegistrationResponse> editAssetRegistration(
            @PathVariable("assetId") String assetId,
            @RequestBody AssetRegistrationRequest request) {
        return assetService.editAssetRegistration(assetId, request);
    }

    @DeleteMapping("/delete/{assetId}")
    public ResultModel<String> deleteAssetRegistration(@PathVariable("assetId") String assetId) {
        return assetService.deleteAssetRegistration(assetId);
    }

    @GetMapping("/get/{assetId}")
    public ResultModel<AssetRegistrationResponse> getAssetRegistrationById(@PathVariable("assetId") String assetId) {
        return assetService.getAssetRegistrationById(assetId);
    }

    @PostMapping("/list")
    public ResultPageModel<AssetRegistrationResponse> getAssetRegistrationListByCondition(@RequestBody AssetRegistrationQuery query) {
        return assetService.getAssetRegistrationListByCondition(query);
    }
}
