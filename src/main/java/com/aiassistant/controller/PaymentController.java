package com.aiassistant.controller;

import com.aiassistant.model.Payment;
import com.aiassistant.service.PaymentService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/select/{paymentId}")
    public ResultModel<Payment> selectPaymentMethod(@PathVariable Integer paymentId) {
        return paymentService.selectPaymentMethod(paymentId);
    }

    @GetMapping("/query/{orderId}")
    public ResultModel<Payment> queryPaymentResult(@PathVariable Integer orderId) {
        return paymentService.queryPaymentResult(orderId);
    }
}
