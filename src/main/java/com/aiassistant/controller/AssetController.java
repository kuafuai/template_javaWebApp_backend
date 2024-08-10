package com.aiassistant.controller;

import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public ResultModel<Asset> addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    @GetMapping
    public ResultPageModel<Asset> getAssetList(
            @RequestParam(required = false) String assetCode,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) LocalDate purchaseDate,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return assetService.getAssetList(assetCode, name, status, purchaseDate, minPrice, maxPrice);
    }
}
