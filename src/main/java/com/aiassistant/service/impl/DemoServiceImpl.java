package com.aiassistant.service.impl;

import com.aiassistant.mapper.DemoMapper;
import com.aiassistant.model.Store;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private final DemoMapper demoMapper;

    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    public ResultModel<Store> addStore(Store store) {
        // Check if the store name and address are valid
        if (store.getName() == null || store.getName().isEmpty()) {
            return ResultModel.ofError("Store name cannot be empty");
        }
        if (store.getAddress() == null || store.getAddress().isEmpty()) {
            return ResultModel.ofError("Store address cannot be empty");
        }

        // Check if the store name already exists
        if (demoMapper.getStoreByName(store.getName()) != null) {
            return ResultModel.ofError("Store name already exists");
        }

        // Insert the store into the database
        demoMapper.insertStore(store);

        return ResultModel.ofSuccess(store);
    }

    @Override
    public ResultPageModel<Store> getStoreList() {
        // Get the list of stores from the database
        List<Store> storeList = demoMapper.getStoreList();

        // Create a ResultPageModel object and set the list of stores
        ResultPageModel<Store> resultPageModel = ResultPageModel.of(storeList);
        resultPageModel.setTotalRecords(storeList.size());

        return resultPageModel;
    }

    @Override
    public ResultModel<Store> getStoreById(Integer id) {
        // Get the store from the database by ID
        Store store = demoMapper.getStoreById(id);

        // Check if the store exists
        if (store == null) {
            return ResultModel.ofError("Store not found");
        }

        return ResultModel.ofSuccess(store);
    }
}
