package com.aiassistant.service.impl;

import com.aiassistant.mapper.StoreMapper;
import com.aiassistant.model.Store;
import com.aiassistant.service.StoreService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public ResultPageModel<Store> getAllStores(Integer pageNo, Integer pageSize) {
        try {
            int totalRecords = storeMapper.countAllStores();
            int totalPage = (int) Math.ceil((double) totalRecords / pageSize);
            int firstIndex = (pageNo - 1) * pageSize;
            List<Store> storeList = storeMapper.selectAllStores(firstIndex, pageSize);
            ResultPageModel<Store> resultPageModel = new ResultPageModel<>();
            resultPageModel.setTotalRecords(totalRecords);
            resultPageModel.setPageNo(pageNo);
            resultPageModel.setPageSize(pageSize);
            resultPageModel.setTotalPage(totalPage);
            resultPageModel.setList(storeList);
            return resultPageModel;
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get all stores", e);
        }
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
