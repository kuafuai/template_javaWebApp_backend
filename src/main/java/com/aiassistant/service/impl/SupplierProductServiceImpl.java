package com.aiassistant.service.impl;

import com.aiassistant.mapper.SupplierProductMapper;
import com.aiassistant.model.SupplierProduct;
import com.aiassistant.service.SupplierProductService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierProductServiceImpl implements SupplierProductService {

    private final SupplierProductMapper supplierProductMapper;

    @Autowired
    public SupplierProductServiceImpl(SupplierProductMapper supplierProductMapper) {
        this.supplierProductMapper = supplierProductMapper;
    }

    @Override
    public ResultModel addSupplierProduct(SupplierProduct supplierProduct) {
        supplierProductMapper.insertSupplierProduct(supplierProduct);
        return ResultModel.ofSuccess("Supplier product added successfully");
    }

    @Override
    public ResultPageModel<SupplierProduct> getSupplierProductList() {
        ResultPageModel<SupplierProduct> resultPageModel = 
          ResultPageModel.of(supplierProductMapper.getSupplierProductList());
        return resultPageModel;
    }
  

    @Override
    public SupplierProduct getSupplierProductByProductModel(String productModel) {
        return supplierProductMapper.selectByProductModel(productModel);
    }
}
