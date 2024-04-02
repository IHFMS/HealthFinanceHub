package com.ihfms.healthfinancehub.financemodule.models;

import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Invoice {

    private int invoiceId;
    private Double amount;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private Patient patient;

}
