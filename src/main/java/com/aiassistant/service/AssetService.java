package com.aiassistant.service;

import com.aiassistant.model.Asset;
import org.springframework.web.multipart.MultipartFile;

/**
 * This interface represents the service for managing assets.
 */
public interface AssetService {
    
    /**
     * Registers a new asset with the provided details and attachment.
     * 
     * @param asset the asset to be registered
     * @param attachment the attachment file for the asset
     * @return the registered asset
     */
    Asset registerAsset(Asset asset, MultipartFile attachment);
}