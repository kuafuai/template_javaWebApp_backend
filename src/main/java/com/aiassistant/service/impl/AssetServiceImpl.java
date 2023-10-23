package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetAssignMapper;
import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.mapper.EmployeeMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.model.AssetAssign;
import com.aiassistant.service.AssetService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;
    private final EmployeeMapper employeeMapper;
    private final AssetAssignMapper assetAssignMapper;

    @Autowired
    public AssetServiceImpl(AssetMapper assetMapper, EmployeeMapper employeeMapper, AssetAssignMapper assetAssignMapper) {
        this.assetMapper = assetMapper;
        this.employeeMapper = employeeMapper;
        this.assetAssignMapper = assetAssignMapper;
    }

    @Override
    public ResultModel<Asset> addAsset(Asset asset) {
        // 校验必填字段
        if (asset.getAssetId() == null || asset.getName() == null || asset.getSpecification() == null ||
                asset.getPurchaseDate() == null || asset.getPurchasePrice() == null) {
            return ResultModel.ofError("Missing required fields");
        }

        // 插入资产信息
        assetMapper.insertAsset(asset);

        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultModel<Asset> getAssetById(String assetId) {
        Asset asset = assetMapper.selectById(assetId);
        if (asset == null) {
            return ResultModel.ofError("Asset not found");
        }
        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultModel<Asset> updateAsset(Asset asset) {
        // 校验必填字段
        if (asset.getAssetId() == null || asset.getName() == null || asset.getSpecification() == null ||
                asset.getPurchaseDate() == null || asset.getPurchasePrice() == null) {
            return ResultModel.ofError("Missing required fields");
        }

        // 更新资产信息
        assetMapper.updateAsset(asset);

        return ResultModel.ofSuccess(asset);
    }

    @Override
    public ResultModel<Asset> deleteAssetById(String assetId) {
        assetMapper.deleteById(assetId);
        return ResultModel.ofSuccess();
    }

    @Override
    public ResultModel<Asset> assignAsset(String assignDate, String employeeId, String assetId) {
        // 验证分配员工工号是否存在于数据库中
        if (employeeMapper.selectById(employeeId) == null) {
            return ResultModel.ofError("Employee not found");
        }

        // 验证分配资产编号是否存在于数据库中
        if (assetMapper.selectById(assetId) == null) {
            return ResultModel.ofError("Asset not found");
        }

        // 保存分配信息到数据库
        AssetAssign assetAssign = new AssetAssign();
        assetAssign.setAssignDate(assignDate);
        assetAssign.setEmployeeId(employeeId);
        assetAssign.setAssetNumber(assetId);
        assetAssignMapper.insertAssetAssign(assetAssign);

        return ResultModel.ofSuccess("Asset assigned successfully");
    }
}
