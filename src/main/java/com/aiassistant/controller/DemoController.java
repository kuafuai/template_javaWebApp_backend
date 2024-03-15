package com.aiassistant.controller;

import com.aiassistant.model.Store;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/addStore")
    public ResultModel addStore(@RequestBody Store store) {
        return demoService.addStore(store);
    }

    @GetMapping("/getStoreList")
    public ResultPageModel<Store> getStoreList() {
        return demoService.getStoreList();
    }

    @GetMapping("/getStoreById")
    public ResultModel<Store> getStoreById(@RequestParam Integer id) {
        return demoService.getStoreById(id);
    }
}
