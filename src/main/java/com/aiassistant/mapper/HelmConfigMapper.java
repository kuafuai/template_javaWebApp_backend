package com.aiassistant.mapper;

import com.aiassistant.model.HelmConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HelmConfigMapper {
    List<HelmConfig> getHelmConfig();

    void updateHelmConfig(HelmConfig config);
}
