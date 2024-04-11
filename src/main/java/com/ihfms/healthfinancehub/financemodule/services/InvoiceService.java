package com.ihfms.healthfinancehub.financemodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class InvoiceService {

    public Invoice generateInvoice(){

        // to generate a random UUID for an invoice

        UUID uuid = UUID.randomUUID();

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(uuid.toString());
        invoice.setIssueDate(LocalDate.now());
        invoice.setDueDate(LocalDate.of(2024, 12, 1));
        invoice.setAmount(1000.0);

        return invoice;
    }

}
