package com.aiassistant.service;

import com.aiassistant.mapper.ConfigMapper;
import com.aiassistant.model.Config;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    @Autowired
    private ConfigMapper configMapper;

    public ResultModel addConfig(Config config) {
        try {
            configMapper.insertConfig(config);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add config", e);
        }
    }

    public ResultModel updateConfigValue(Config config) {
        try {
            configMapper.updateConfigValue(config);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update config value", e);
        }
    }

    public ResultModel updateConfigStatus(Config config) {
        try {
            configMapper.updateConfigStatus(config);
            return ResultModel.ofSuccess();
        } catch (Exception e) {
            return ResultModel.ofError("Failed to update config status", e);
        }
    }

    public ResultModel<String> getConfigValue(String configKey, String defaultValue) {
        try {
            String configValue = configMapper.getConfigValue(configKey);
            if (configValue != null) {
                return ResultModel.ofSuccess(configValue);
            } else {
                return ResultModel.ofSuccess(defaultValue);
            }
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get config value", e);
        }
    }
}
