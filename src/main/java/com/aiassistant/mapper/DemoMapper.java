package com.aiassistant.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {
    @Insert("INSERT INTO demo (file_path) VALUES (#{filePath})")
    void uploadZipFile(@Param("filePath") String filePath);
}
