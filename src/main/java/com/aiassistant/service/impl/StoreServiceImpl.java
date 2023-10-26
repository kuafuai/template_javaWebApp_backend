package com.aiassistant.service.impl;

import com.aiassistant.mapper.StoreMapper;
import com.aiassistant.model.Store;
import com.aiassistant.service.StoreService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public ResultModel<Store> addStore(Store store) {
        try {
            storeMapper.insertStore(store);
            return ResultModel.ofSuccess(store);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add store", e);
        }
    }
}
