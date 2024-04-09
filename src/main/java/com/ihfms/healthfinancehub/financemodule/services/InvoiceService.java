package com.ihfms.healthfinancehub.financemodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.healthmodule.repos.PatientRepository;
import com.ihfms.healthfinancehub.healthmodule.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Service
public class InvoiceService {

    public Invoice generateInvoice(){

        // to generate a random UUID for an invoice


        String id = UUID.randomUUID().toString();

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(id);
        invoice.setIssueDate(LocalDate.now());
        invoice.setDueDate(LocalDate.of(2024, 12, 1));
        invoice.setAmount(1000.0);

        return invoice;
    }

}
