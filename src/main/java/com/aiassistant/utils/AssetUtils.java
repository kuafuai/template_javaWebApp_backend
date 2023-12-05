package com.aiassistant.utils;

import java.util.UUID;

public class AssetUtils {
    public static String generateAssetId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
