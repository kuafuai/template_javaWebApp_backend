package com.aiassistant.service.impl;

import com.aiassistant.mapper.AssetMapper;
import com.aiassistant.model.Asset;
import com.aiassistant.service.AssetService;
import com.aiassistant.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AssetServiceImpl implements AssetService {

    private final AttachmentService attachmentService;
    private final AssetMapper assetMapper;

    @Autowired
    public AssetServiceImpl(AttachmentService attachmentService, AssetMapper assetMapper) {
        this.attachmentService = attachmentService;
        this.assetMapper = assetMapper;
    }

    @Override
    public Asset registerAsset(Asset asset, MultipartFile attachmentFile) {
        Assert.notNull(asset, "Asset must not be null");
        Assert.notNull(attachmentFile, "Attachment file must not be null");

        try {
            // Save the attachment file
            int attachmentId = attachmentService.addAttachment(attachmentFile);

            // Set the attachment ID in the asset
            asset.getAttachment().setId(attachmentId);

            // Save the asset
            assetMapper.insertAsset(asset);

            return asset;
        } catch (Exception e) {
            // Handle any error or exception that may occur during the execution
            throw new RuntimeException("Failed to register asset", e);
        }
    }
}