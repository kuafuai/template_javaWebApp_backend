package com.aiassistant.mapper;

import com.aiassistant.model.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {
    @Insert("INSERT INTO store (name,address,timestamp) VALUES (#{name}, #{address}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertStore(Store store);

    @Select("SELECT * FROM store")
    List<Store> selectAllStores();
}
