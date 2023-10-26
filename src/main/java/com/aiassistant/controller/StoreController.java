package com.aiassistant.controller;

import com.aiassistant.model.Store;
import com.aiassistant.service.StoreService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/store")
    public ResultModel addStore(@RequestBody Store store) {
        return storeService.addStore(store);
    }
}
