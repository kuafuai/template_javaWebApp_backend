package com.aiassistant.controller;

import com.aiassistant.model.Store;
import com.aiassistant.service.StoreService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/add")
    public ResultModel addStore(@RequestBody Store store) {
        return storeService.addStore(store);
    }

    @GetMapping("/getAll")
    public ResultPageModel getAllStores(Integer pageNo, Integer pageSize) {
        return storeService.getAllStores(pageNo, pageSize);
    }
}
