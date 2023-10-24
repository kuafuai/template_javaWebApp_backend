package com.example.mapper;

import com.example.model.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    void insertStore(Store store);
}
