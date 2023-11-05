package com.aiassistant.service;

import com.aiassistant.model.SupplierProduct;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface SupplierProductService {
    ResultModel addSupplierProduct(SupplierProduct supplierProduct);
    ResultPageModel<SupplierProduct> getSupplierProductList(String productCode);
    SupplierProduct getSupplierProductByProductModel(String productModel);
}
