package com.aiassistant.mapper;

import com.aiassistant.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    @Insert("INSERT INTO file (name, path, size, create_time) VALUES (#{name}, #{path}, #{size}, #{createTime})")
    void insertFile(File file);
}
