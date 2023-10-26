package com.aiassistant.mapper;

import com.aiassistant.model.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface StoreMapper {
    @Insert("INSERT INTO store (name,address,timestamp) VALUES (#{name}, #{address}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertStore(Store store);
}
