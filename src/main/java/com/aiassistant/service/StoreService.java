package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.Store;
import com.aiassistant.utils.ResultPageModel;

public interface StoreService {
    ResultModel<Store> addStore(Store store);
    ResultPageModel<Store> getAllStores(Integer pageNo, Integer pageSize);
}
