package com.aiassistant.service;

import com.aiassistant.utils.HelmUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class HelmService {
    public Map<String, Object> parseValueYaml(MultipartFile file) {
        return HelmUtils.parseValueYaml(file);
    }

    public Map<String, Object> getHelmConfig() {
        // TODO: Implement this method
        return null;
    }

    public void updateHelmConfig(Map<String, Object> config) {
        // TODO: Implement this method
    }

    public void deployHelmPackage() {
        // TODO: Implement this method
    }
}
