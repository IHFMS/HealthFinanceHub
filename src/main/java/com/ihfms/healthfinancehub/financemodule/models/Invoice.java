package com.ihfms.healthfinancehub.financemodule.models;

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
