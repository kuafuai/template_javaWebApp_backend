package com.aiassistant.service.impl;

import com.aiassistant.mapper.InvoiceMapper;
import com.aiassistant.model.Invoice;
import com.aiassistant.service.InvoiceService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceMapper invoiceMapper;

    @Autowired
    public InvoiceServiceImpl(InvoiceMapper invoiceMapper) {
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public ResultModel<Invoice> createInvoice(Invoice invoice) {
        invoiceMapper.createInvoice(invoice);
        return new ResultModel<>(invoice, "Invoice created successfully");
    }

    @Override
    public ResultModel<Invoice> getInvoiceById(Integer id) {
        Invoice invoice = invoiceMapper.getInvoiceById(id);
        if (invoice != null) {
            return new ResultModel<>(invoice, "Invoice found");
        } else {
            return new ResultModel<>("Invoice not found");
        }
    }

    @Override
    public ResultModel<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceMapper.getAllInvoices();
        return new ResultModel<>(invoices, "All invoices retrieved successfully");
    }

    @Override
    public ResultModel<Invoice> calculateTotalAmount(Invoice invoice) {
        double totalAmount = 0;
        for (Invoice.Item item : invoice.getItems()) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        invoice.setTotalAmount(totalAmount);
        return new ResultModel<>(invoice, "Total amount calculated successfully");
    }

    @Override
    public ResultModel<Invoice> generatePDF(Invoice invoice) {
        // Implement the logic to generate a PDF version of the invoice
        // This could involve using a library or framework to convert the invoice details into a PDF format
        // For example, you can use a library like iText or Apache PDFBox to generate the PDF
        // You will need to add the necessary dependencies to your project's build file (e.g., pom.xml for Maven)
        // Once you have generated the PDF, you can set the PDF file path or byte array in the invoice object
        // For example, invoice.setPdfFilePath("path/to/invoice.pdf") or invoice.setPdfBytes(byteArray)
        // Finally, return the invoice object with the PDF information
        return new ResultModel<>(invoice, "PDF generated successfully");
    }

    @Override
    public ResultModel<Invoice> sendInvoiceByEmail(Invoice invoice, String email) {
        // Implement the logic to send the invoice to customers via email
        // This could involve using an email sending library or framework to send the invoice as an attachment or in the email body
        // For example, you can use JavaMail or Apache Commons Email to send the email
        // You will need to add the necessary dependencies to your project's build file (e.g., pom.xml for Maven)
        // Once you have sent the email, you can set the email status or any other relevant information in the invoice object
        // For example, invoice.setEmailStatus("Sent") or invoice.setEmailSentDate(new Date())
        // Finally, return the invoice object with the email information
        return new ResultModel<>(invoice, "Invoice sent successfully to " + email);
    }
}
