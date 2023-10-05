package com.aiassistant.service;

import com.aiassistant.model.Invoice;
import com.aiassistant.utils.ResultModel;

import java.util.List;

public interface InvoiceService {
    ResultModel<Invoice> createInvoice(Invoice invoice);

    ResultModel<Invoice> getInvoiceById(Integer id);

    ResultModel<List<Invoice>> getAllInvoices();

    ResultModel<Invoice> calculateTotalAmount(Invoice invoice);

    ResultModel<Invoice> generatePDF(Invoice invoice);

    ResultModel<Invoice> sendInvoiceByEmail(Invoice invoice, String email);
}
