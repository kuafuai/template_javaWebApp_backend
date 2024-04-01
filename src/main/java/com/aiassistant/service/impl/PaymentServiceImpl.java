package com.aiassistant.service.impl;

import com.aiassistant.mapper.PaymentMapper;
import com.aiassistant.model.Payment;
import com.aiassistant.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentServiceImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentMapper.getAllPayments();
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public void addPayment(Payment payment) {
        paymentMapper.addPayment(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentMapper.updatePayment(payment);
    }

    @Override
    public void deletePayment(int id) {
        paymentMapper.deletePayment(id);
    }
}
