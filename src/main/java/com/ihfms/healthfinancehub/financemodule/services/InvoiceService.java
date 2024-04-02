package com.ihfms.healthfinancehub.financemodule.services;

import com.ihfms.healthfinancehub.financemodule.models.Invoice;
import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import com.ihfms.healthfinancehub.healthmodule.repos.PatientRepository;
import com.ihfms.healthfinancehub.healthmodule.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InvoiceService {

    public Invoice generateInvoice(){

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(123);
        invoice.setIssueDate(LocalDate.now());
        invoice.setDueDate(LocalDate.of(2024, 12, 1));
        invoice.setAmount(1000.0);

        return invoice;
    }

}
