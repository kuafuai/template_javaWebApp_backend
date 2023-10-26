package com.aiassistant.mapper;

import com.aiassistant.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface FileMapper {
    @Insert("INSERT INTO file (file_name, file_type, file_size, file_url, create_time) VALUES (#{fileName}, #{fileType}, #{fileSize}, #{fileUrl}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertFile(File file);
}
