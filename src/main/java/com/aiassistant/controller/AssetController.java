package com.aiassistant.controller;

import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset")
public class AssetController {
    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("/add")
    public ResultModel<Asset> addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    @GetMapping("/{assetId}")
    public ResultModel<Asset> getAssetById(@PathVariable String assetId) {
        return assetService.getAssetById(assetId);
    }

    @PutMapping("/update")
    public ResultModel<Asset> updateAsset(@RequestBody Asset asset) {
        return assetService.updateAsset(asset);
    }

    @DeleteMapping("/{assetId}")
    public ResultModel<Asset> deleteAssetById(@PathVariable String assetId) {
        return assetService.deleteAssetById(assetId);
    }
}
