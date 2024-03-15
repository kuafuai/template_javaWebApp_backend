package com.aiassistant.service;

import com.aiassistant.model.Store;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface DemoService {
    ResultModel<Store> addStore(Store store);

    ResultPageModel<Store> getStoreList();

    ResultModel<Store> getStoreById(Integer id);
}
