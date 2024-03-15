package com.aiassistant.mapper;

import com.aiassistant.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    @Insert("INSERT INTO file_info (file_name, file_path, file_size, create_time) VALUES (#{fileName}, #{filePath}, #{fileSize}, #{createTime})")
    void insertFile(File file);
}
