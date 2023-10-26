package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.model.Store;

public interface StoreService {
    ResultModel<Store> addStore(Store store);
}
