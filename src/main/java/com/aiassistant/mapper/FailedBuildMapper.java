package com.aiassistant.mapper;

import com.aiassistant.model.FailedBuild;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FailedBuildMapper {
    @Insert("INSERT INTO failed_build (project_name, reason) VALUES (#{projectName}, #{reason})")
    FailedBuild insertFailedBuild(FailedBuild failedBuild);
}
