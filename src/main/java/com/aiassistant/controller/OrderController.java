package com.aiassistant.controller;

import com.aiassistant.model.Order;
import com.aiassistant.service.OrderService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResultModel<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/list")
    public ResultPageModel<Order> getOrderList(@RequestParam(required = false) String orderNo,
                                               @RequestParam(required = false) Date startTime,
                                               @RequestParam(required = false) Date endTime) {
        return orderService.getOrderList(orderNo, startTime, endTime);
    }

    @PutMapping("/update")
    public ResultModel<Order> updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResultModel<Order> deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }
}
