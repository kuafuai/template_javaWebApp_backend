package com.aiassistant.mapper;

import com.aiassistant.model.ModelUsage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ModelUsageMapper {
    @Insert("INSERT INTO t_model_usage(model_id, usage_count) VALUES(#{modelId}, #{usageCount})")
    void insertModelUsage(ModelUsage modelUsage);
}
