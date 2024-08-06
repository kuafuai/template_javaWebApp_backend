package com.aiassistant.controller;

import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public ResultModel<Asset> addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    @GetMapping
    public ResultPageModel<Asset> getAssetList() {
        return assetService.getAssetList();
    }
}
