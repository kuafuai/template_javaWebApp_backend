package com.aiassistant.controller;

import com.aiassistant.model.SupplierProduct;
import com.aiassistant.service.SupplierProductService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplierProduct")
public class SupplierProductController {
    private final SupplierProductService supplierProductService;

    @Autowired
    public SupplierProductController(SupplierProductService supplierProductService) {
        this.supplierProductService = supplierProductService;
    }

    @PostMapping("/add")
    public ResultModel addSupplierProduct(SupplierProduct supplierProduct) {
        return supplierProductService.addSupplierProduct(supplierProduct);
    }

    @PostMapping("/list")
    public ResultPageModel<SupplierProduct> getSupplierProductList() {
        return supplierProductService.getSupplierProductList();
    }
}
