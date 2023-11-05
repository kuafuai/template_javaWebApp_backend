package com.aiassistant.controller;

import com.aiassistant.model.SupplierProduct;
import com.aiassistant.service.SupplierProductService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplierProduct")
@CrossOrigin(origins = {"*"})
public class SupplierProductController {
    private final SupplierProductService supplierProductService;

    @Autowired
    public SupplierProductController(SupplierProductService supplierProductService) {
        this.supplierProductService = supplierProductService;
    }

    @PostMapping("/add")
    public ResultModel addSupplierProduct(@RequestBody SupplierProduct supplierProduct) {
        return supplierProductService.addSupplierProduct(supplierProduct);
    }

    @PostMapping("/save")
    public ResultModel saveSupplierProduct(SupplierProduct supplierProduct) {
        return supplierProductService.addSupplierProduct(supplierProduct);
    }

    @GetMapping("/list")
    public ResultPageModel<SupplierProduct> getSupplierProductList(@RequestParam(name = "productCode", required = false) String productCode) {
        return supplierProductService.getSupplierProductList(productCode);
    }
}
