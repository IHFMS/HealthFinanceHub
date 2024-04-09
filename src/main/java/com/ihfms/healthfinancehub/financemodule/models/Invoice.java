package com.ihfms.healthfinancehub.financemodule.models;

import com.ihfms.healthfinancehub.healthmodule.models.Patient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Invoice {

    private String invoiceId;
    private Double amount;
    private LocalDate issueDate;
    private LocalDate dueDate;
    Boolean isPaid;
    private Long patientId;

}
