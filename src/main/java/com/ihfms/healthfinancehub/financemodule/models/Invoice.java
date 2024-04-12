package com.ihfms.healthfinancehub.financemodule.models;

import lombok.Data;
import java.sql.Date;

@Data
public class Invoice {

    private Long invoiceId;
    private Double amount;
    private Date issueDate;
    private Date dueDate;
    Boolean isPaid;
    private Long patientId;

}
