package com.aiassistant.service;

import com.aiassistant.model.Order;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

import java.util.Date;

public interface OrderService {
    ResultModel<Order> createOrder(Order order);

    ResultPageModel<Order> getOrderList(String orderNo, Date startTime, Date endTime);

    ResultModel<Order> updateOrder(Order order);

    ResultModel<Order> deleteOrder(Integer orderId);
}
