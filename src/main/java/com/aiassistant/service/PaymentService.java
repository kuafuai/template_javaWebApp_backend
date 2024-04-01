package com.aiassistant.service;

import com.aiassistant.model.Payment;
import com.aiassistant.utils.ResultModel;

public interface PaymentService {
    ResultModel<Payment> selectPaymentMethod(Integer paymentId);

    ResultModel<Payment> queryPaymentResult(Integer orderId);
}
