package com.aiassistant.mapper;

import com.aiassistant.model.SupplierProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplierProductMapper {
    @Insert("insert into supplier_product(product_model,delivery_time,product_price,deliverable_quantity,trading_counterparty,advance_payment_ratio) " +
            "values(#{productModel},#{deliveryTime},#{productPrice},#{deliverableQuantity},#{tradingCounterparty},#{advancePaymentRatio})")
    void insertSupplierProduct(SupplierProduct supplierProduct);

    @Select("select * from supplier_product")
    List<SupplierProduct> getSupplierProductList();

    @Select("select * from supplier_product where product_model like '%' || #{productModel} || '%'")
    List<SupplierProduct> getSupplierProductListByModel(String productModel);


    @Select("select * from supplier_product where product_model = #{productModel} limit 1")
    SupplierProduct selectByProductModel(String productModel);
}
